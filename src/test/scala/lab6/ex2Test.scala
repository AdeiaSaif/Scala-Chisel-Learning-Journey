package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class CounterTest extends FreeSpec with ChiselScalatestTester {
  "Chisel Tester file " in {
    test(new Counter(0,5)) { a =>
      a.clock.step(1)
      a.io.out.expect(1.U)
      a.clock.step(1)
      a.io.out.expect(2.U)
      a.clock.step(1)
      a.io.out.expect(3.U)
      a.clock.step(1)
      a.io.out.expect(4.U)
      a.clock.step(1)
      a.io.out.expect(5.U)
      

    }
  }
}
