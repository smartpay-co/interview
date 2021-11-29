package data

final case class Checkout(
    id: Checkout.Id,
    amount: Amount,
    currency: Currency,
    lineItems: List[LineItem],
    card: Card
)

object Checkout {
  final case class Id(value: String) extends AnyVal
}
