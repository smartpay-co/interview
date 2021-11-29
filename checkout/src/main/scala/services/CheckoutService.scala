package services

import stores.CheckoutStore

trait CheckoutService[F[_]] {
  def checkout(): F[Unit]
}

object CheckoutService {

  def make[F[_]](checkoutStore: CheckoutStore[F]): CheckoutService[F] = new Impl[F](checkoutStore)

  final class Impl[F[_]](checkoutStore: CheckoutStore[F]) extends CheckoutService[F] {

    override def checkout(): F[Unit] = ???

  }

}
