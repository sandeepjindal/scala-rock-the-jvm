val xs = Array("1","2","3")

xs.view.zipWithIndex

for((x,i) <- xs.view.zipWithIndex) println("String #" + i + " is " + x)
