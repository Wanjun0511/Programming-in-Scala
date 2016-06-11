package Second

/**
  * Created by liuwanjun on 6/11/16.
  */

object Programming4 extends App{
  def salt()={println("salt");false}
  def pepper()={println("pepper");true}
  println(salt() && pepper())
  println(pepper() && salt())

  println(~1)   //~按位异或运算
}
