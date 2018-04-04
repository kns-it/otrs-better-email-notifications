package de.knsit.otrsBen.ldap.exceptions

/**
 * @author Peter Kurfer
 * Created on 4/3/18.
 */
class AmbiguousSearchResultException(message: String) : Exception(message) {
    constructor() : this("")
}