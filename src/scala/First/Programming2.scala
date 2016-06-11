package First

/**
  * Created by liuwanjun on 6/11/16.
  */

import scala.collection.mutable.Map

class ChecksumAccumulator {   //类定义
  var ss=0
  private var sum=0
  def add(b:Byte):Unit= sum+=b
  def checkSum():Int= ~(sum &0xFF)+1
}

object ChecksumAccumulator {  //定义单例对象。当单例对象与某个类共享同一个名称时,它就被称为
//是这个类的伴生对象。类被称为是这个单例对象的伴生类。类和它的伴生对象必须定义在同一个源文件中。
// 类和它的伴生对象可以互相访问其私有成员。 单例对象不带参数,而类可以。
  val acc=new ChecksumAccumulator  //创建实例
  println(acc.ss)
  acc.ss=3
  println(acc.ss)
  acc.sum=4
  println(acc.sum)

  private val cache=Map[String,Int]()  //可变映射,见上面import
  def calculate(s:String):Int={
    if(cache.contains(s))
      cache(s)
    else{
      val aaa=new ChecksumAccumulator
      for(z<-s)
        aaa.add(z.toByte)
      val zs=aaa.checkSum()
      cache+=(s->zs)
      zs
    }
  }

  println(acc.sum+1)
  println(calculate("Every day"))
}

object Test extends App{  //不与伴生类共享名称的单例对象被称为独立对象
  val csa=new ChecksumAccumulator
  csa.ss=5
  println(csa.ss)
  //println(csa.sum)  //Error! 因为sum是私有的

  println(ChecksumAccumulator.calculate("Every day!"))  //能成功,当object ChecksumAccumulator的
  // extends App删掉。而且它不是只调用了calcuate,而是把object ChecksumAccumulator中所有的都走了一遍

  println(csa.ss+1)
}
// 由以下结果可以看出, object Test的执行顺序是: 先执行Test中调用calculate之前的语句;
// 调用calcualte时进入object ChecksumAccumulator, 执行除calcualte之外的所有语句,
// 包括ChecksumAccumulator里面调用calculate的语句;然后执行Test中调用calculate的语句; 最后执行Test中剩余部分的语句。
//5
//0
//3
//4
//5
//-105
//-138
//6