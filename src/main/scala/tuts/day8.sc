def multiply(implicit by: Int) = 2 * by


implicit val multiplier = 2
implicit def f: Int = if (true) 4 else 2


multiply


def example1(implicit x: Int)                       // x is implicit
def example2(implicit x: Int, y: Int)               // x and y are implicit
def example3(x: Int, implicit y: Int)
def example4(x: Int)(implicit y: Int)               // only y is implicit
def example5(implicit x: Int)(y: Int)
def example6(implicit x: Int)(implicit y: Int)
