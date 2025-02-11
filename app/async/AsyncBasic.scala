package async

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * You have 2 webservices, we want to compute the sum of the 2 webservice call.
 *
 * You need to write only the compute function.
 * For instance : compute(1) should return 1099 (1098 + 1)
 *
 * It's part of the exercise to handle error cases
 */
object AsyncBasic {

  def compute(id: String): Future[Int] = {
    Webservice1.call(id) flatMap { eitherA =>
      Webservice2.call(id) flatMap { eitherB =>
        (eitherA, eitherB) match {
          case (Some(a), Right(b)) => Future.successful(a + b)
          case (None, _) => throw new Exception("Webservice 1 issue")
          case (_, Left(err)) => throw new Exception("Webservice 2 issue " + err)
        }
      }
    }


  }
}

object Webservice1 {
  private[this] val result = Map(
    "1" -> 1,
    "2" -> 21,
    "5" -> 4,
    "10" -> 1987
  )

  def call(id: String): Future[Option[Int]] = Future(result.get(id))
}

object Webservice2 {
  private[this] val result = Map(
    "1" -> 1098,
    "3" -> 218777,
    "9" -> 434,
    "10" -> Int.MaxValue
  )

  def call(id: String): Future[Either[String, Int]] = Future {
    result.get(id) match {
      case Some(x) => Right(x)
      case None => Left("No value")
    }
  }
}
