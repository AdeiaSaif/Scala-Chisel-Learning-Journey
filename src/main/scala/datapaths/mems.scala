package datapaths
import chisel3._
import chisel3.util._
import chisel3.util.experimental.loadMemoryFromFile
import scala.io.Source

class mems(initFile: String) extends Module {
  val io = IO(new Bundle {
    val address = Input(UInt(32.W))
    val din = Input(SInt(32.W))
    val enb=Input(Bool())
    val dout = Output(UInt(32.W))
  })
    val memory = Mem(1024, UInt(32.W))
    loadMemoryFromFile(memory, initFile)
    io.dout:=memory(io.address/4.U )
  
}
