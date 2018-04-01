package de.knsit.otrsBen.dal.entities

import de.knsit.otrsBen.dal.annotations.FieldMapping

/**
 * @author Peter Kurfer
 * Created on 4/1/18.
 */
data class Ticket(
        @FieldMapping("ticket", "id")
        var id: Long = 0,
        @FieldMapping("ticket", "tn")
        var ticketNumber: String = "",
        @FieldMapping("ticket", "title")
        var title: String = "",
        @FieldMapping("ticket", "customer_user_id")
        var customerLogin: String = ""
)