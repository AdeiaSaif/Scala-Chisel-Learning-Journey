package lab6
import chisel3._
import chisel3.util._

class ex1(val init: Int = 1) extends Module {
  val io = IO(new Bundle {
    val in = Input(Bool())
    val sel = Input(Bool())
    val out = Output(UInt(4.W))
  })

  val state = RegInit(init.U(4.W))

  when(io.sel) {
    state := io.in
  }.otherwise {
    val next = state << 1
    state := next
  }

  io.out := state
}

