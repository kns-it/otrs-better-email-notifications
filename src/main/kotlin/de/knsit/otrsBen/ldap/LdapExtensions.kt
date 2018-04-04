package de.knsit.otrsBen.ldap

import javax.naming.NamingEnumeration
import javax.naming.directory.Attribute
import javax.naming.directory.Attributes

/**
 * @author Peter Kurfer
 * Created on 4/3/18.
 */
fun Attributes.toMap(): Map<String, Any> {
    val resultMap: MutableMap<String, Any> = mutableMapOf()
    val namingEnumeration: NamingEnumeration<out Attribute>? = all
    while (namingEnumeration != null && namingEnumeration.hasMore()) {
        val tmp = namingEnumeration.next()
        resultMap[tmp.id] = tmp.get()
    }

    return resultMap
}