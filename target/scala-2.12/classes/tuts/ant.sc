// not lazy
val x = "sandeep"
//lazy
def z = "sandy"
var y = "ayushi"
//x = "new"
println(x)
y = "new"
//z = "ds"


case class Ticket (state:String,id: Int)


val v = List( Ticket("Open",1),Ticket("Closed",2))

val states = Seq("Open")

def getTicket ( id:Int): Option[Ticket] = {
return  v.find(x => (states contains x.state) &&  (x.id == id))
}

getTicket(2)


