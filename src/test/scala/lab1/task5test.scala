package practice

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class task5test extends FreeSpec with ChiselScalatestTester {
  "Chisel Tester file" in {
    test(new lab1task5(5.U)) { a =>
      a.io.a.poke(4.U)
      a.clock.step(20)
      a.io.out.expect(1.U)
    }
  }
}                                            