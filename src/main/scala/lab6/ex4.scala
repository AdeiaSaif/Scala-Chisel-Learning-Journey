package lab6
import chisel3._
import chisel3.util._

class IO1 extends Bundle {
  val in = Flipped(Decoupled(UInt(8.W)))
  val out = Decoupled(UInt(8.W))
}

class IO2 extends Bundle {
  val in = Flipped(Decoupled(UInt(8.W)))
  val out = Decoupled(UInt(8.W))
}

class mod1 extends Module {
  val io = IO(new Bundle {
       val io1 = new IO1
       val io2 = new IO2 

  })
  io.io2.in.ready:=true.B
  val queue1 = Queue(io.io1.in, 5)
  io.io1.out <> queue1

  val queue2 = Queue(queue1, 5)
  io.io2.out <> queue2
}
