package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class two_shotTest extends FreeSpec with ChiselScalatestTester {
  "Chisel Tester file " in {
    test(new one_shot) { a =>
      a.io.din.poke(5.U)
      a.io.reload.poke(true.B)
      a.clock.step(1)
      
      a.io.reload.poke(false.B)
      a.clock.step(1)
      a.clock.step(1)
      a.clock.step(1)
      a.clock.step(1)

      a.clock.step(1)
      a.clock.step(1)
      a.clock.step(1)
      a.clock.step(1)
      
      

    }
  }
}
