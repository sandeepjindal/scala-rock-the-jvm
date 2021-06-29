package rockthejvm

import akka.actor.SupervisorStrategy.{Restart, Stop}
import akka.actor.{Actor, ActorLogging, ActorSystem, OneForOneStrategy, PoisonPill, Props, Stash, SupervisorStrategy}
import akka.util.Timeout

object AkkaRecap extends App{

  class SimpleActor extends Actor with ActorLogging with Stash {
    override def receive: Receive = {
      case "createChild" => val childActor =context.actorOf(Props[SimpleActor],"myChild")
        childActor ! "hello from child"
      case "stashThis" => stash()
      case "change handler NOW" => unstashAll()
        context.become(anotherHandler)
      case "change" => context.become(anotherHandler)
      case message => println(s"I recieved: $message")
    }

    def anotherHandler: Receive = {
      case message => println(s"another recieved: $message")
    }

    override def preStart(): Unit = {
      log.info("I am starting")
//      println("am starting!!")
    }

    override def supervisorStrategy: SupervisorStrategy = OneForOneStrategy() {
      case _: RuntimeException => Restart
      case _ => Stop
    }
  }

  val system = ActorSystem("AkkaRecap")
  //#1 we can only instantiate actor through actor system
  val actor = system.actorOf(Props[SimpleActor])


  // #2 sending messages ask method

  actor ! "hello"

  /**
   * messages are sent async manner
   * many actors (in millions) can share few dozen threads
   * each message is processed/handled ATOMICALLY
   * no need for locking
   */

  // changing actor behaviour + stashing
  // actors can spawn other actors
  // guardians: /system, /user, / = root guardian

  // actors have a defined lifecycle: they can be started, stopped, suspended, resumed, restarted

  //stopping actors - context.stop
//  actor ! PoisonPill

  //logging
  //supervision

  // configure Akka infrastructure: dispatchers, routers, mailboxes

  //schedulers
  import scala.concurrent.duration._
  import system.dispatcher
  system.scheduler.scheduleOnce(2 seconds){
    actor ! "delayed happy birthday"
  }

  // Akka patterns including FSM + ask pattern
  import akka.pattern.ask
  implicit val timeout = Timeout(3 seconds)

  val future = actor ? "question" // completed with first reply

  // the pipe pattern
  import akka.pattern.pipe
  val anotherActor = system.actorOf(Props[SimpleActor],"anotherActor")

  future.mapTo[String].pipeTo(anotherActor)
}
