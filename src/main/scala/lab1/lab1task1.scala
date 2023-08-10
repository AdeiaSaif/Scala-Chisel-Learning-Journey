package practice
import chisel3._
class Counter(countbit:SInt) extends Module{
    val io=IO(new Bundle{
        val result=Output(SInt(32.W))
    })
    val max= (1.S <<countbit.asUInt)-1.S
    val c=RegInit(0.S(32.W))
    when(c===max){
        c:=0.S
    }
    .otherwise{
        c:=c+1.S
    }
    io.result:=c
   println(s"$max")}