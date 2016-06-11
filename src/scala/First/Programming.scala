package scala.First

import scala.collection.immutable.HashSet

/**
  * Created by liuwanjun on 6/3/16.
  */


object Programming extends App{

  var Cap=Map("China"->"Beijing","US"->"Washington")  //定义了一个映射,默认是不可变的Map
  Cap += ("Japan"->"Tokyo")  //必须用var定义才能添加
  println(Cap("Japan"))

  def max(x:Int,y:Int):Int= if(x>y) x else y   //用def定义函数
  println(max(5,11))

  val Num=List(1,2,3)  //List是不可变的同类对象序列
  for(i<-0 to 2)
    println(Num(i))

  val Args=Array("Scala","is","fun\n")    // while循环
  var i=0
  while(i<Args.length){
    println(Args(i))
    i+=1
  }

  Args.foreach(arg=>println(arg))   //用foreach做枚举,arg是函数字面量。相当于for(arg<-Args). arg是val.
  Args.foreach(print)   // 当函数字面量只有一行语句并且只有一个参数时,不需要指代参数

  ////////////////数组Array///////////////////////////////
  val lwj=new Array[String](3)    //新建一个长度为3的字符串数组
  lwj(0)="Liu"
  lwj(1)="Zi"
  lwj(2)="Jun"
  for(i<-0 to 2)
    print(lwj(i))
  print("\n")
  lwj(1)="Wan"     //lwj是val,因此不能改变, 但字符串数组内部的元素始终能被修改。因此数组本身是可变的
  for(i<-0 to 2)
    print(lwj(i))
  print("\n")
  //val lwj=Array("Liu","Wan","Jun")

  //////////////////列表List//////////////////////////////
  val First=List(1,2,3)  //List是不可变的同类对象序列, Array是可变的同类对象序列
  print(First)
  val Second=List(5,6,7)
  val Third= First:::Second //:::叠加两个List
  print(Third)
  val Zero=0::First   //::将新元素添加到列表的最前端
  print(Zero)
  val FirstAgain=1::2::3::Nil  // 同样是定义新列表。Nil是空列表的简写
  print(FirstAgain)
  val Nothing=List()   //空List
  print(Nothing)
  println(Zero(0))

  val Thrill="Will"::"fill"::"until"::Nil
  val N=Thrill.count(s=>s.length==4) //Thrill中长度为4的元素有几个
  println(N)
  val S1=Thrill.drop(2)  //去掉前两个元素
  println(S1)
  val S2=Thrill.dropRight(2) //去掉后两个元素
  println(S2)

  /////////////////不可变集set//////////////////////////////
  var jetSet=Set("Boing","Airbus")
  jetSet +="Lear"    //对不可变集使用+实际是创建了新的set,重新赋给了jetSet
  //由于对不可变集使用+必须要重新赋值,所以jetSet必须定义为var
  println(jetSet.contains("Lear"))
  //如果要定义可变的Set, 就需要加入引用
  // import scala.collection.mutable.Set
  //并且定义成val。默认是使用不可变的。见Programming1

  var hashSet=HashSet("Tomatoes","Chilies")  // 见上面的import,不可变的HashSet
  hashSet+="Coriander"   //使用+的时候必须定义成var,但如果不使用+,则可以定义成val
  println(hashSet)


  //可变的Map,见Programming1


}
