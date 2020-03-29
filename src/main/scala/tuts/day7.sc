//Day 7
import scala.concurrent.TimeoutException

//val s = "Foo"
//try {
//  val i = s.toInt
//} catch {
//  case e: Exception => println("dsadasdadw)
//  case _ => println()
//}


import java.io.FileReader
import java.io.File
import java.io.FileNotFoundException

val file = new File("/Users/sjindal/td.txt")

val fr1 = new FileReader(file)

//val fr = try {new FileReader(file)}
//catch {
//  case e: FileNotFoundException => print("File Not found as this is a exception")
//  case _ => print("Something else")
//}