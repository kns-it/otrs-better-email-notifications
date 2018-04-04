package de.knsit.otrsBen.ldap.annotations

/**
 * @author Peter Kurfer
 * Created on 4/3/18.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class LdapAttribute(val attributeName: String)