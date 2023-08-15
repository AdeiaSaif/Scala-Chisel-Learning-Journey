package lab3m
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals
class ex2test extends FreeSpec with ChiselScalatestTester{
    "Chisel " in{
        test(new ex2){a=>
        a.io.Opcode.poke(9.U)
        a.io.A.poke(12.S)
        a.io.B.poke(1.S)
        a.clock.step(1)
        a.io.out.expect(6.U)    
        }
    }
}