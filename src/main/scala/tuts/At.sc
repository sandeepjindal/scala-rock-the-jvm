//DAY 1


// how to create list -- Done
//val list = 1 :: 2 :: 3 :: Nil
//
val listAnt = List(4,8,13)

//val listSandy = List("hi ","wassup", " sandy!!")

//
////
//List.range(0, 15)
////
////val x = List.fill(3)(0)
////
//List.tabulate(5)(n => n * n)
//
////List.range(0,5).map(x => x * x)
//
////
////
////
////// map, filter, reduce -- Done
////val newList = List(listAnt.filter(x => (x > 8 && x < 15).head).filter(_ > 15)
//val x = listAnt.reduce(_ - _)
//listSandy.reduce(_ + _)
//
//list.filter(_ > 2)


//
listAnt.map(_ * 3)
//
//// function d[eclartion
def g (v: Int)  = v+1

//
listAnt.map (x => g(x))

//=> // it works over collection
//scala collections,iterables ??
// difference between => <- -> , why function with =
// blanket with =>
