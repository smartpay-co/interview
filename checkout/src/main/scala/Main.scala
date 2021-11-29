import cats.effect._

object Main extends IOApp {
  def run(args: List[String]) =
    Server.serve.compile.drain.as(ExitCode.Success)
}
