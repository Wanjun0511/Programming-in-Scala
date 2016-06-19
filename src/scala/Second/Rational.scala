package Second

/**
  * Created by liuwanjun on 6/12/16.
  */
class Rational(n:Int,d:Int) {
  require(d!=0)  // 检查先决条件

  private val g=gcd(n.abs,d.abs)  //私有字段
  val numer=n/g
  val denom=d/g

  def this(n:Int)=this(n,1)  //辅助构造器

  override def toString=numer+"/"+denom    //重新实现toString方法

  def + (that:Rational):Rational =
    new Rational( numer*that.denom+denom*that.numer, denom*that.denom)    //返回的是一个类

  def +(i:Int) : Rational =       //解决整数与有理数相加。方法重载
    new Rational( i* denom+numer,denom)
  //方法调用时,编译器会拣出正确的匹配了参数类型的重载方法版本
  def * (that:Rational):Rational =
    new Rational( numer*that.numer, denom*that.denom)

  def * (i:Int) :Rational =
    new Rational(i*numer,denom)

  def - (that:Rational):Rational =
    new Rational(numer*that.denom- denom*that.numer, denom*that.denom)

  def - (i:Int):Rational =
    new Rational(numer-i*denom,denom)

  def / (that:Rational):Rational =
    new Rational(numer*that.denom, denom*that.numer)

  def / (i: Int):Rational =
    new Rational(numer,i*denom)

  private def gcd(a:Int, b:Int):Int= {     //私有方法
    if (b == 0)
      a
    else
      gcd(b,a%b)
  }
}

object Rational extends App{
  val x1 =new Rational(1,3)
  println(x1)
  val x2=new Rational(4,6)
  println(x2)
  println(x1+x2)
  println(x1+x1*x2)
  println(x1/x2)
  println(x1*2)
  // 现在可以执行x1*2,但是不能执行2*x1, 因为Int类没有带Rational参数的乘法
  // 自动把整数转换成有理数的隐式转换:

  implicit def intToRational (x:Int) =new Rational(x)
  println(2*x1)
  // 隐式转换要起作用,必须定义在作用范围之内
}