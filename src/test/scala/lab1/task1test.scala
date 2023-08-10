package practice
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class task1test extends FreeSpec with ChiselScalatestTester {
  "Chisel test " in {
    test(new Counter(4.S)) { a =>
      a.clock.step(35)
      a.io.result.expect(15.S)
    }
  }
}
