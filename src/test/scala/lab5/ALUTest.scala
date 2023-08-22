package lab5
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class ALUTest extends FreeSpec with ChiselScalatestTester{
    "Chisel " in{
        test(new ALU(32)){a=>
            a.io.arg_x.poke(3.U)
            a.io.arg_y.poke(1.U)
            a.io.alu_op.poke(1.U)
            a.clock.step(1)
            a.io.alu_out.expect(2.U)    
        }
    }
}