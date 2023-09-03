package lab6
import chisel3._
import chisel3.util._

class Counter(val min: Int = 0, val max: Int) extends Module {
  val io = IO(new Bundle {
    val out = Output(UInt(32.W))
  })

  val counter = RegInit(min.U(32.W)) 

  val count_buffer = Mux((isPow2(max) && (min == 0)).B,counter + 1.U,Mux(counter === max.U, min.U, counter + 1.U))
  counter := count_buffer
  io.out := counter
}
