package lab5
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class ex2test extends FreeSpec with ChiselScalatestTester{
    "Chisel " in{
        test(new ex2(UInt(32.W))){a=>
            a.io.in_a.poke(3.U)
            a.io.in_b.poke(1.U)
            a.io.sel.poke(1.B)
            a.clock.step(1)
            a.io.out.expect(3.U)    
        }
    }
}