package practice
import chisel3._
class lab1task5(n: UInt) extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(5.W))
    val out = Output(UInt(5.W)) 
  })

  val counter = RegInit(0.U(10.W))
val flag= RegInit(1.U(1.W))
  when(flag === 1.U && counter === io.a) {
    counter := counter - 1.U
    flag := 0.U
  }.elsewhen(flag=== 1.U && counter < io.a) {
    counter := counter + 1.U 
}.elsewhen(flag === 0.U && counter === 0.U) {
   counter := counter + 1.U
  flag := 1.U
  }.elsewhen(flag === 0.U && counter > 0.U) {
    counter := counter - 1.U
  }

  io.out := counter
}