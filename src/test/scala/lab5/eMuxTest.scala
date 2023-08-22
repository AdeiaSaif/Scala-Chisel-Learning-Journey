package lab5
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class eMuxTest extends FreeSpec with ChiselScalatestTester{
    "Chisel "in{
        test(new eMux(SInt(32.W),SInt(32.W),SInt(32.W))){a=>
        a.io.inp1.poke(12.S)
        a.io.inp2.poke(1.S)
        a.io.sel.poke(true.B)
        a.clock.step(1)

        a.io.outp.expect(12.S)     

        }
    }
}