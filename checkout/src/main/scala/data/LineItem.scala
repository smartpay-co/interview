package data

final case class LineItem(
    id: LineItem.Id,
    description: LineItem.Description,
    amount: Amount,
    currency: Currency,
    quantity: LineItem.Quantity
)

object LineItem {
  final case class Id(value: String) extends AnyVal
  final case class Description(value: String) extends AnyVal
  final case class Quantity(value: Int) extends AnyVal
}
