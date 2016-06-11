package scala.First

import scala.collection.mutable.{Map, Set}
import scala.io.Source

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

  ///////////////不使用val和有副作用的方法///////////
  /////输出字符串数组
  def formatArgs(args:Array[String])=args.mkString("\n")
  val Ans=formatArgs(Array("one","two","three"))
  assert(Ans=="one\ntwo\nthree")   //结果为真就什么都不做

  ////////////////从文件里读取文本行/////////////////
  val File="/Users/liuwanjun/Documents/IDEA/src/scala/First/data.txt"
  var lines=Source.fromFile(File).getLines().toList  //字符串列表。因为之后要遍历两遍,所以存成列表比较方便
  //1. 输出每一行的长度的最大宽度
  def WidthOfLineLength(s:String)=s.length.toString.length
  var maxWidth=0
  for(line<-lines)
    maxWidth=maxWidth.max(WidthOfLineLength(line))
  //2. 让数字右对齐
  for(line<-lines){
    val NumSpace=maxWidth-WidthOfLineLength(line)
    val padding=" "*NumSpace
    println(padding+line.length+"|"+line)
  }

}
