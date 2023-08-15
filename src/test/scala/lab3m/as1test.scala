package lab3m
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class as1test extends FreeSpec with ChiselScalatestTester{
    "Chisel " in{
        test(new BranchControl){a=>
            a.io.branch.poke(true.B)
            a.io.fnct3.poke(7.U)
            a.io.A.poke(12.U)
            a.io.B.poke(2.U)
            a.clock.step(1)
            a.io.out.expect(true.B)
          
        }
    }
}