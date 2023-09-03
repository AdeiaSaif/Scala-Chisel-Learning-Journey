package lab6
import chisel3._
import chisel3.util._

class one_shot extends Module {
  val io = IO(new Bundle {
    val din = Input(UInt(32.W))
    val reload = Input(Bool())
    val out = Output(UInt(32.W))
    val out1 = Output(UInt(32.W))
  })

  val timer_count = RegInit(0.U(8.W))
  val timer2count = RegInit(4.U(8.W))
  val done = timer_count === 0.U
  val next = WireInit(0.U(32.W))
  val next1 = WireInit(0.U(32.W))
  val sec = RegInit(true.B)

  when(io.reload) {
    next := io.din
    next1 := io.din
  }
  .elsewhen(!done ) {
    next := timer_count - 1.U
  }
  .elsewhen(done) {
    next1 := timer2count - 1.U
  }

  timer_count := Mux(sec, next, 0.U)
  timer2count := Mux(sec, 0.U, next1)

  io.out := timer_count
  io.out1 := timer2count
}
