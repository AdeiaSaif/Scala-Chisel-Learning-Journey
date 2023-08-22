package lab5
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class paraTest extends FreeSpec with ChiselScalatestTester {
    "Chisel " in {
        test(new rou(UInt(32.W))) { a =>
            a.io.in.data.poke(12.U)
            a.io.in.address.poke(1.U)
            a.io.in.valid.poke(true.B)
            a.clock.step(1)

            a.io.out.data.expect(12.U)
            a.io.out.address.expect(1.U)
        }
    }
}