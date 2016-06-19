package Second

/**
  * Created by liuwanjun on 6/19/16.
  */

object ForLoop extends App{

  val filesHere = (new java.io.File("/Users/liuwanjun/Documents/zen_FM/zen")).listFiles
  for(file<-filesHere)
    println(file)

  for(file <- filesHere if file.getName.endsWith(".xml"))   //过滤
    println("XML:"+file)

  for(file <- filesHere if file.isFile; if file.getName.endsWith("l"))  //输出以l结尾的文件,而不是文件夹(目录)
    println(file)

  //嵌套枚举
  val files= (new java.io.File("/Users/liuwanjun/Documents/IDEA/src/scala/Second")).listFiles
  def fileLines(file:java.io.File)=
    scala.io.Source.fromFile(file).getLines.toList

  def grep(pattern:String) =
    for(file <- files if file.getName.endsWith(".scala") ; line<- fileLines(file) if line.trim.matches(pattern))
      println(file + ": "+ line.trim)

  grep(".*gcd.*")

  // 流间变量绑定。修改上面的grep方法
  def grep2(pattern:String) =
    for{file <- files
        if file.getName.endsWith(".scala")
        line<- fileLines(file)
        trimmed=line.trim    //不带关键字val
        if trimmed.matches(pattern)
    } println(file + ": "+ trimmed)
}
