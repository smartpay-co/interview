package data

final case class Card(
    id: Card.Id,
    holderName: Card.HolderName,
    number: Card.Number,
    securityCode: Card.SecurityCode,
    expMonth: Card.ExpMonth,
    expYear: Card.ExpYear
)

object Card {
  final case class Id(value: String) extends AnyVal
  final case class HolderName(value: String) extends AnyVal
  final case class Number(value: Int) extends AnyVal
  final case class SecurityCode(value: Int) extends AnyVal
  final case class ExpMonth(value: Int) extends AnyVal
  final case class ExpYear(value: Int) extends AnyVal
}
