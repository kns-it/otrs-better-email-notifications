package de.knsit.otrsBen.ldap

import javax.naming.directory.Attributes

/**
 * @author Peter Kurfer
 * Created on 4/3/18.
 */
fun Attributes.toMap(): Map<String, Any> = all?.toList()?.groupBy { it.id }?.mapValues { it.value.first().get() }
        ?: mapOf()