package practice
import chisel3._
class task3(size:Int,Max:Int) extends Module{
    val io=IO(new Bundle{
        val result= Output(Bool())
    })
    var count=RegInit( 0.U(32.W))
    def getcount(n:Int ,max:Int)={
        when(count===max.asUInt){
            count:=0.U
        }
        .otherwise{
            count:=count+1.U
        }
        count

    }

    val obj=getcount(size,Max)
    io.result:=count
}