package de.knsit.otrsBen.config

/**
 * @author Peter Kurfer
 * Created on 4/1/18.
 */
interface SmtpConfig {
    var senderAddress: String
    var friendlySenderName: String
    var smtpHost: String
    var smtpPort: Short
    var username: String
    var password: String
    var useSSL: Boolean
    var useCredentials: Boolean
}