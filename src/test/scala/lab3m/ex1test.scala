package lab3m
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals
class ex1test extends FreeSpec with ChiselScalatestTester{
    "Chisel " in{
        test(new ex1){a=>
        a.io.in.poke("b0010".U)
        a.clock.step(1)
        a.io.out.expect(1.U)    
        }
    }
}