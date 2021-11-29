package prices.services

import cats.implicits._
import cats.effect._
import org.http4s._
import org.http4s.circe._
import org.http4s.client.Client

import prices.data._

object SmartcloudInstanceKindService {

  final case class Config(
      baseUri: String,
      token: String
  )

  def make[F[_]: Concurrent](config: Config, client: Client[F]): InstanceKindService[F] = new SmartcloudInstanceKindService(config, client)

  private final class SmartcloudInstanceKindService[F[_]: Concurrent](
      config: Config,
      client: Client[F]
  ) extends InstanceKindService[F] {

    implicit val instanceKindsEntityDecoder: EntityDecoder[F, List[String]] = jsonOf[F, List[String]]

    val getAllUri = s"${config.baseUri}/instances"

    override def getAll(): F[List[InstanceKind]] =
      Uri.fromString(getAllUri).liftTo[F].flatMap { uri =>
        val request = Request[F](
          method = Method.GET,
          uri = uri,
          headers = Headers(headers.Authorization(Credentials.Token(AuthScheme.Bearer, config.token)))
        )

        client.run(request).use {
          case Status.Successful(r) =>
            r.as[List[String]].map(_.map(InstanceKind(_)))
          case resp =>
            resp.asJson.flatMap(r => MonadCancelThrow[F].raiseError(InstanceKindService.Exception.APICallFailure(r.noSpaces)))
        }
      }

  }

}
