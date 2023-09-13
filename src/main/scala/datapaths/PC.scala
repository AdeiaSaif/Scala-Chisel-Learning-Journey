package datapaths
import chisel3._
import chisel3.util._

class PC( val min:Int =0) extends Module{
    val io=IO(new Bundle{
        val enb=Input(Bool())
        
        val in=Input(UInt(32.W))
        val out=Output(UInt(32.W))
    })
    val PCs=RegInit(min.U(32.W))
    //PCs:=Mux(io.enb,io.in,PCs+io.in)
    PCs:=PCs+io.in
    io.out:=PCs
}