package org.fpdomain.dmodel

import java.util.{ Date ⇒ JDate, Calendar ⇒ JCalendar }

object common {
  type Amount = BigDecimal

  def today = JCalendar.getInstance.getTime
}

import common._

case class Balance(amount: Amount = 0)

case class Account(no: String, name: String, dateOfOpening: JDate = today, dateOfClosing: Option[JDate] = None,
                   balance: Balance = Balance(0))
