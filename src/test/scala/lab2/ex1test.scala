package practice
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class ex1test extends FreeSpec with ChiselScalatestTester{
    "Chisel " in{
        test(new ex1) {a=>
            a.io.a.poke(12.U)
            a.io.b.poke(4.U)
            a.io.sel.poke(1.B)
            a.clock.step(8)
            a.io.out.expect(12.U)
        }
    }
}
