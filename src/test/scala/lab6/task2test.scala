package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class task2test extends FreeSpec with ChiselScalatestTester {
  "Chisel " in {
    test(new task2(5)) { a =>
      a.clock.step(5)
      a.io.out.expect(0.U)
     
    }
  }
}
