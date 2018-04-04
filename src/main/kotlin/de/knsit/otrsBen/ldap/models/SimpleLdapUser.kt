package de.knsit.otrsBen.ldap.models

import de.knsit.otrsBen.ldap.annotations.LdapAttribute

/**
 * @author Peter Kurfer
 * Created on 4/4/18.
 */
data class SimpleLdapUser(
        @LdapAttribute("sAMAccountName")
        var sAMAccountName: String = "",
        @LdapAttribute("mail")
        var mailAddress: String = "",
        @LdapAttribute("givenName")
        var firstName: String,
        @LdapAttribute("sn")
        var lastName: String,
        @LdapAttribute("displayName")
        var displayName: String,
        @LdapAttribute("cn")
        var fullName: String
)