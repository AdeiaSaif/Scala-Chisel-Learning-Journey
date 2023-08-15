package lab3m

import chisel3._
import chisel3.util._

class ex2 extends Module {
  val io = IO(new Bundle {
    val Opcode = Input(UInt(7.W))
    val A = Input(SInt(32.W))
    val B = Input(SInt(32.W))
    val out = Output(UInt(32.W))
  })

  val ADD = 0.U(4.W)
  val SUB = 1.U(4.W)
  val AND = 2.U(4.W)
  val OR = 3.U(4.W)
  val XOR = 4.U(4.W)
  val SLT = 5.U(4.W)
  val SLL = 6.U(4.W)
  val SLTU = 7.U(4.W)
  val SRL = 8.U(4.W)
  val SRA = 9.U(4.W)
  val COPY_A = 10.U(4.W)
  val COPY_B = 11.U(4.W)
  val XXX = 15.U(4.W)

  io.out := 0.U

  switch(io.Opcode) {
    is(0.U) {
      io.out := (io.A + io.B).asUInt
    }
    is(1.U) {
      io.out := (io.A - io.B).asUInt
    }
    is(2.U) {
      io.out := (io.A & io.B).asUInt
    }
    is(3.U) {
      io.out := (io.A | io.B).asUInt
    }
    is(4.U) {
      io.out := (io.A ^ io.B).asUInt
    }
    is(5.U) {
      io.out := Mux(io.A < io.B, 1.U, 0.U)
    }
    is(6.U) {
      val shift = io.B(4, 0)
      io.out := io.A<< shift
    }
    is(7.U) {
      io.out := Mux(io.A.asUInt < io.B.asUInt, 1.U, 0.U)
    }
    is(8.U) {
      val shift = io.B(4, 0)
         io.out := io.A>> shift
    }
    is(9.U) {
      val shift = io.B(4, 0)
      io.out :=  io.A>> shift
    }
    is(10.U) {
      io.out := io.A.asUInt
    }
    is(11.U) {
      io.out := io.B.asUInt
    }
  }
}
