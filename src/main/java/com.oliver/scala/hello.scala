object HelloWorld {


    val map=Map("kobe"->8,"hadeng"->10,"curry"->30)

    def main(args: Array[String]): Unit = {
        println("Hello, world!")
        val a=10
        val b=11
        val m=min(a,b)
        println("min is",m)

        val slist=new Array[String](10)
        slist(0)="google"
        slist(1)="baidu"
        slist(2)="badidu"
        showList(slist)
        mulParam(slist(0),slist(1),slist(1))

    }

    /**
      * 返回较小的值
      * @param a
      * @param b
      * @return
      */
    def min(a :Int,b:Int)={
        if (a>=b)
             b
        else
             a
    }

    def showList(strlist:Array[String])={
        for(i <- 0 to strlist.length-1){
            println(strlist(i))
        }

    }

    def mulParam(args:String*)={
        for(i<- 0 until args.length){
            println(args(i))
        }
    }
}