package practice
import chisel3._
class Countermsb(countbit:UInt) extends Module{
    val io=IO(new Bundle{
        //val input=Input(UInt(4.W))
        val result=Output(Bool())
    })
   // val max= (1.U <<countbit)-1.U
    val c=RegInit(15.U(4.W))
    when( c.getWidth.U- 1.U =/= 0.U ){
        c:=c+1.U
    }
    .otherwise{
        c:=0.U
    }
    io.result:=c;
   println(s"$c")}