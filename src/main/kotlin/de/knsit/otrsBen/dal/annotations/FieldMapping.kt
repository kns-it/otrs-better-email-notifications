package de.knsit.otrsBen.dal.annotations

/**
 * @author Peter Kurfer
 * Created on 4/1/18.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class FieldMapping(val table: String, val column: String)