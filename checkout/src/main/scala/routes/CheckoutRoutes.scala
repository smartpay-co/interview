package routes

import cats.effect._
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import org.http4s.server.Router

import services.CheckoutService

case class CheckoutRoutes[F[_]: Sync](checkoutService: CheckoutService[F]) extends Http4sDsl[F] {

  val prefix = "/v1/checkouts"

  private val create: HttpRoutes[F] = HttpRoutes.of {
    case POST -> Root => ???
  }

  def routes: HttpRoutes[F] =
    Router(
      prefix -> create
    )

}
