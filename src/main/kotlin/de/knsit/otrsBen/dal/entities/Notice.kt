package de.knsit.otrsBen.dal.entities

import de.knsit.otrsBen.dal.annotations.FieldMapping
import java.sql.Timestamp

/**
 * @author Peter Kurfer
 * Created on 4/1/18.
 */
data class Notice(
        @FieldMapping("article", "id")
        var id: Long,
        @FieldMapping("article", "a_from")
        var from: String,
        @FieldMapping("article", "a_subject")
        var subject: String,
        @FieldMapping("article", "a_body")
        var body: String,
        @FieldMapping("article", "create_time")
        var creationTime: Timestamp,
        var ticket: Ticket
)