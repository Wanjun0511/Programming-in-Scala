package First

/**
  * Created by liuwanjun on 6/11/16.
  */

import ChecksumAccumulator.calculate
//import是根据类的名字来写的,不是文件的名字

object Programming3 {
  def main(args:Array[String]): Unit = {
    for(arg<-args)
      println(arg+":"+calculate(arg))
  }
}

object ForTest extends App {
  for (season<-List("Spring","Summer","Fall"))
    println(season+":"+calculate(season))
}