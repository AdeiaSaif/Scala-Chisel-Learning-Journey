package datapaths
import chisel3._
import chisel3.util._

class PC4( val min:Int =0) extends Module{
    val io=IO(new Bundle{
       // val op=Input(UInt(7.W))
        
        val in=Input(UInt(32.W))
        val out=Output(UInt(32.W))
    })
    val PCs=RegInit(min.U(32.W))
    PCs:=PCs+4.U 
    io.out:=PCs
}