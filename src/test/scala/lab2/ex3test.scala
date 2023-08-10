package lab2
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class ex3test extends FreeSpec with ChiselScalatestTester {
  "Chisel" in {
    test(new ex3) { a =>
      a.io.a.poke(0.U) 
      a.io.b.poke(1.U) 
      a.io.c.poke(2.U) 
      a.io.d.poke(3.U) 
      a.io.s.poke(8.U) 
      a.clock.step(1) 

      a.io.out.expect(3.U)
    }
  }
}
