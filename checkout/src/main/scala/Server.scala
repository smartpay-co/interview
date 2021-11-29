import cats.effect._
import com.comcast.ip4s._
import fs2.Stream
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.middleware.Logger

import routes.CheckoutRoutes
import services.CheckoutService
import stores.CheckoutStore

object Server {

  def serve: Stream[IO, ExitCode] = {
    val checkoutStore   = CheckoutStore.makeInMemory[IO]
    val checkoutService = CheckoutService.make[IO](checkoutStore)

    val httpApp = (
      CheckoutRoutes[IO](checkoutService).routes
    ).orNotFound

    Stream
      .eval(
        EmberServerBuilder
          .default[IO]
          .withHost(ipv4"0.0.0.0")
          .withPort(port"8888")
          .withHttpApp(Logger.httpApp(true, true)(httpApp))
          .build
          .useForever
      )
  }
}
