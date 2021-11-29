package prices.services

import scala.util.control.NoStackTrace

import cats.Applicative
import cats.implicits._

import prices.data._

trait InstanceKindService[F[_]] {
  def getAll(): F[List[InstanceKind]]
}

object InstanceKindService {

  sealed trait Exception extends NoStackTrace
  object Exception {
    case class APICallFailure(message: String) extends Exception
  }

  def makeDummy[F[_]: Applicative](): InstanceKindService[F] = new DummyInstanceKindService[F]()

  final class DummyInstanceKindService[F[_]: Applicative]() extends InstanceKindService[F] {

    override def getAll(): F[List[InstanceKind]] =
      List("sc2-micro", "sc2-small", "sc2-medium").map(InstanceKind(_)).pure[F]

  }

}
