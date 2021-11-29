package stores

import data._

trait CheckoutStore[F[_]] {
  def insert(checkout: Checkout): F[Unit]
}

object CheckoutStore {

  def makeInMemory[F[_]]: CheckoutStore[F] = new InMemoryImpl()

  final class InMemoryImpl[F[_]]() extends CheckoutStore[F] {

    override def insert(checkout: Checkout): F[Unit] = ???

  }

}
