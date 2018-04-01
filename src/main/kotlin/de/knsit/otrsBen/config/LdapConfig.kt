package de.knsit.otrsBen.config

import javax.naming.Context

/**
 * @author Peter Kurfer
 * Created on 4/1/18.
 */
interface LdapConfig {
    var ldapUri: String
    var baseDn: String
    var bindDn: String
    var bindPw: String
    var userSearchFilter: String
}

fun LdapConfig.toLdapEnvironment(): HashMap<String, String> = hashMapOf(
        Context.SECURITY_AUTHENTICATION to "simple",
        "java.naming.ldap.attributes.binary" to "objectSID",
        Context.INITIAL_CONTEXT_FACTORY to "com.sun.jndi.ldap.LdapCtxFactory",
        Context.SECURITY_PRINCIPAL to bindDn,
        Context.SECURITY_CREDENTIALS to bindPw,
        Context.PROVIDER_URL to ldapUri
)