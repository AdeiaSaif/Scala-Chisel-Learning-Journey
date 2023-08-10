package practice
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class task2test extends FreeSpec with ChiselScalatestTester {
  "Chisel test " in {
    test(new Countermsb(5.U)) { a =>
      a.clock.step(100)
      a.io.result.expect(1.B)
    }
  }
}
