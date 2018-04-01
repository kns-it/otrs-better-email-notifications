package de.knsit.otrsBen.config

/**
 * @author Peter Kurfer
 * Created on 4/1/18.
 */
interface DbConfig {
    var jdbcUri: String
    var username: String
    var password: String
}

fun DbConfig.toJpaConfigMap(): Map<String, String> = mapOf(
        "javax.persistence.jdbc.url" to jdbcUri,
        "javax.persistence.jdbc.user" to username,
        "javax.persistence.jdbc.password" to password
)