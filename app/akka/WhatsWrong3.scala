package akka

import akka.actor.Actor

import scala.concurrent.Future
import scala.util.{ Failure, Success }
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Do you see anything that could lead to potential problems ?
 * yes, the actor is sending to himself a Future, and since the future is async,
 * the Actor could start processing the next several messages while
 * the future with the actual message is still running.
 *
 * What would you do to fix it ?
 * I d rather use the pipeTo instead of (onComplete) method to send the result of the Future` to `self`
 * and handle it.
 * Do not mind about the not implemented code
 */
class WhatsWrong3 extends Actor {

  var internalState = "internal state"

  def receive: Receive = {
    case "a query" => {
      val requestF: Future[String] = queryAsyncServer()
      requestF.onComplete {
        case Success(r) => handleResponse(r)
        case Failure(e) => e.printStackTrace()
      }
    }
  }

  def handleResponse(r: String) = ??? // mutate internal state

  def queryAsyncServer(): Future[String] = ???
}
