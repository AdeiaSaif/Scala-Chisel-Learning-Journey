package lab3m
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class immtest extends FreeSpec with ChiselScalatestTester{
    "Chisel " in{
        test(new imm){a=>
            a.io.ins.poke("b00000000110000000000000010010011".U)
            a.clock.step(1)
            a.io.imm.expect("b000000001100".U)
          
        }
    }
}