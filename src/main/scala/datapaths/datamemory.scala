package datapaths
import chisel3._
import chisel3.util._

class datamemory extends Module {
  val io = IO(new Bundle {
    val address = Input(UInt(32.W))
    val din = Input(SInt(32.W))
    val enb = Input(Bool())
    val load = Input(Bool())
    val store = Input(Bool())
    val dout = Output(SInt(32.W))
  })
  val memory = Mem(1024, SInt(32.W))
  when(io.store === 1.B) {
    memory.write(io.address, io.din)
  }
  io.dout := Mux(io.load === 1.B, memory(io.address), 0.S)

}
