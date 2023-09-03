package lab6
import chisel3._
import chisel3.util._

class task4(val max: Int = 1) extends Module {
  val io = IO(new Bundle {
    val up_down=Input(Bool())
    val out = Output(UInt((log2Ceil(max).W)))
  })
  val counter = RegInit(0.U(log2Ceil(max).W))
  when(counter< max.U && io.up_down) {
    counter := counter + 1.U
  }
    .elsewhen(counter=== max.U || ~(io.up_down)) {
      counter := counter - 1.U
    }
 io. out := counter

}
