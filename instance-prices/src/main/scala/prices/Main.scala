package prices

import cats.effect.{ IO, IOApp }
import org.http4s.ember.client.EmberClientBuilder

import prices.config.Config

object Main extends IOApp.Simple {
  def run: IO[Unit] = EmberClientBuilder.default[IO].build.use { client =>
    for {
      config <- Config.load[IO]
      _ <- Server.serve(config, client).compile.drain
    } yield ()
  }
}
