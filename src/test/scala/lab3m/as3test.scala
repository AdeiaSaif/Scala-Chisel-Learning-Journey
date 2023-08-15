package lab3m
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class as3test extends FreeSpec with ChiselScalatestTester{
    "Chisel " in{
        test(new as3){a=>
            a.io.in.poke("b01".U)
            a.clock.step(1)
            a.io.out.bits.expect("b0010".U)
            a.io.out.valid.expect(true.B)

          
        }
    }
}