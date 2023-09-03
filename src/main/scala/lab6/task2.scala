package lab6
import chisel3._
import chisel3.util._

class task2(val max: Int = 1) extends Module {
  val io = IO(new Bundle {
    val out = Output(UInt((log2Ceil(max).W)))
  })
  val counter = RegInit(0.U(log2Ceil(max).W))
  when(counter((log2Ceil(max)) - 1) ^ 1.B) {
    counter := counter + 1.U
  }
    .otherwise {
      counter := 0.U
    }
 io. out := counter

}
