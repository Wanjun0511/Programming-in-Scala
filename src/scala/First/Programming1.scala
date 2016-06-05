package scala.First

import scala.collection.mutable.{Map, Set}
/**
  * Created by liuwanjun on 6/5/16.
  */
object Programming1 extends App{

  ///////////////////可变集Set//////////////////
  val movieSet=Set("Hitch","Poltergeist") //由于movieSet是可变集,不需要重新赋值,所以定义为val
  movieSet+="Shrek"
  println(movieSet)

  val treasureMap=Map[Int,String]()   //见上面的import, 可变的Map
  treasureMap+=(1->"Go to island")
  treasureMap+=(2->"Find big X on ground")
  treasureMap+=(3->"Dig")
  println(treasureMap(2))

// val rNumber=Map(1->"I",2->"II",3->"III") // 可推断类型参数

}
