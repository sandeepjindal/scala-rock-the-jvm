//package monix
//
//import monix.eval.Task
//
//import scala.concurrent.{ExecutionContext, Future}
//
//object TheContext extends App {
//
//  // What's wrong with Future
//  import scala.concurrent.ExecutionContext.Implicits.global
//  val repo = new ProductRepository {}
//  repo.findProduct(1)
//}
//
//trait ProductRepository {
//  def findProduct(
//      productId: Int
//  )(implicit executor: ExecutionContext): Future[Option[Int]] = Future {
//    Some(1)
//  }
//
//  def saveProduct(
//      product: Int
//  )(implicit executor: ExecutionContext): Future[Unit] = Future {}
//
//  def incrementProductSells(
//      productId: Int,
//      quantity: Int
//  )(implicit executor: ExecutionContext): Future[Unit] = Future {}
//
//  // More methods ...
//}
//
//object TheContextTask extends App {
//  implicit val scheduler = monix.execution.Scheduler.Implicits.global
//  val repoTask = new ProductRepositoryTask {}
//  repoTask.findProduct(1).runAsync
//}
//
//trait ProductRepositoryTask {
//  def findProduct(
//      productId: Int
//  ): Task[Option[Int]] = Task {
//    Some(1)
//  }
//
//  def saveProduct(
//      product: Int
//  ): Task[Unit] = Task {}
//
//  def incrementProductSells(
//      productId: Int,
//      quantity: Int
//  ): Task[Unit] = Task {}
//
//  // More methods ...
//}
