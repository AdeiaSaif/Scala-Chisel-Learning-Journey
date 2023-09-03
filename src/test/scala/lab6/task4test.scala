package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class task4test extends FreeSpec with ChiselScalatestTester {
  "Chisel " in {
    test(new task4(5)) { a =>
        a.io.up_down.poke(true.B)
      a.clock.step(5)
      a.io.up_down.poke(false.B)
      a.clock.step(5)
      a.io.out.expect(0.U)
     
    }
  }
}
