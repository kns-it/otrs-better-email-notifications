package de.knsit.otrsBen.ldap

import de.knsit.otrsBen.ldap.annotations.LdapAttribute
import org.apache.commons.beanutils.BeanUtils
import java.lang.reflect.InvocationTargetException
import javax.naming.directory.SearchResult

/**
 * @author Peter Kurfer
 * Created on 4/3/18.
 */
class LdapAttributeMapper<out T : Any>(private val mappingTargetType: Class<T>) {

    private val fieldMappings: List<LdapFieldMapping> = mappingTargetType.declaredFields
            .filter { it.isAnnotationPresent(LdapAttribute::class.java) }
            .map { LdapFieldMapping(it.getAnnotation(LdapAttribute::class.java).attributeName, it.name) }
            .toList()

    private val _ldapFields: Array<String>

    val ldapFields: Array<String>
        get() = _ldapFields

    init {
        _ldapFields = fieldMappings
                .map { it.ldapAttributeName }
                .toTypedArray()
    }

    fun createInstanceFromResult(searchResult: SearchResult): T {
        try {
            val ldapFieldValues = searchResult.attributes.toMap()
            val instance = mappingTargetType.getDeclaredConstructor().newInstance()
            for (mapping in fieldMappings) {
                try {
                    if (!ldapFieldValues.containsKey(mapping.ldapAttributeName)) continue
                    BeanUtils.setProperty(instance, mapping.fieldName, ldapFieldValues[mapping.ldapAttributeName])
                } catch (e: InvocationTargetException) {
                    //TODO log error
                }
            }
            return instance
        } catch (e: Exception) {
            //TODO log error
            throw e
        }
    }
}

private data class LdapFieldMapping(val ldapAttributeName: String, val fieldName: String)