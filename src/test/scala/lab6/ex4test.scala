package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class ex4test extends FreeSpec with ChiselScalatestTester {
  "Chisel " in {
    test(new mod1) { a =>
            a.io.io1.in.valid.poke(true.B)
            a.io.io1.in.bits.poke(5.U)
            a.io.io1.out.ready.poke(true.B)
            a.clock.step(1)
            a.io.io1.out.valid.expect(true.B)
            a.io.io1.in.ready.expect(true.B)
            a.io.io1.out.bits.expect(5.U)

            a.clock.step(1)
            a.io.io2.out.valid.expect(true.B)
            a.io.io2.in.ready.expect(true.B)
            a.io.io2.out.bits.expect(5.U)
     
    }
  }
}
