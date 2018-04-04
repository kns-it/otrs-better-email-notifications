package de.knsit.otrsBen.ldap

import de.knsit.otrsBen.config.LdapConfig
import de.knsit.otrsBen.config.toLdapEnvironment
import de.knsit.otrsBen.ldap.exceptions.AmbiguousSearchResultException
import java.util.*
import javax.naming.directory.SearchControls
import javax.naming.ldap.InitialLdapContext
import javax.naming.ldap.LdapContext

/**
 * @author Peter Kurfer
 * Created on 4/3/18.
 */
class LdapUserLookup<T: Any>(private val ldapConfig: LdapConfig, private val ldapAttributeMapper: LdapAttributeMapper<T>) : AutoCloseable {

    private val ldapContext: LdapContext = InitialLdapContext(ldapConfig.toLdapEnvironment(), null)

    fun getUserBySAMAccountName(sAMAccountName: String): Optional<T> {
        val searchFilter = SearchControls().apply {
            searchScope = SearchControls.SUBTREE_SCOPE
            returningAttributes = ldapAttributeMapper.ldapFields
        }

        try {
            val ldapSearchResults = ldapContext.search(ldapConfig.baseDn, String.format(ldapConfig.userSearchFilter, sAMAccountName), searchFilter)
            val searchResults = ldapSearchResults.toList()
            ldapSearchResults.close()
            if(searchResults.size > 1) throw AmbiguousSearchResultException("Found more than one LDAP user")
            return if(searchResults.isEmpty()) Optional.empty() else Optional.of(ldapAttributeMapper.createInstanceFromResult(searchResults[0]))
        } catch (e: Exception) {
            //TODO log error
            throw e
        }
    }

    override fun close() {
        //TODO log closing connection
        ldapContext.close()
    }

}