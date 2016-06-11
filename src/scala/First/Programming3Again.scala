package First

/**
  * Created by liuwanjun on 6/11/16.
  */

import ChecksumAccumulator1._

object Programming3Again {
  def main(args:Array[String]): Unit = {
    val ccc=new ChecksumAccumulator1
    for(arg<-args)
      println(arg+":"+ccc.calculate(arg))
  }
}

object ForTest1 extends App {
  val bbb=new ChecksumAccumulator1   //创建实例时就会初始化,执行里面的print语句
  for (season<-List("Spring","Summer","Fall"))
    println(season+":"+bbb.calculate(season))
}

//0
//Spring:-115
//Summer:-121
//Fall:-127