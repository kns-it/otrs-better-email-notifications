package de.knsit.otrsBen.ldap

import de.knsit.otrsBen.ldap.models.SimpleLdapUser
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * @author Peter Kurfer
 * Created on 4/4/18.
 */
class LdapAttributeMapperTests {

    @Test
    fun `test create LDAP attribute mapper`() {
        val attributeMapper = LdapAttributeMapper(SimpleLdapUser::class.java)
        assertEquals(6, attributeMapper.ldapFields.size)
    }
}