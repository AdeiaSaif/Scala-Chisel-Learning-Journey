package lab2
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class ex2test extends FreeSpec with ChiselScalatestTester {
  "Chisel" in {
    test(new ex2) { a =>
      a.io.in0.poke(true.B) 
      a.io.in1.poke(false.B) 
      a.io.in2.poke(false.B) 
      a.io.in3.poke(false.B) 
      a.io.in4.poke(false.B) 
      a.io.in5.poke(false.B) 
      a.io.in6.poke(false.B) 
      a.io.in7.poke(false.B) 
      a.io.s0.poke(0.U)
      a.io.s1.poke(0.U)
      a.io.s2.poke(0.U)

      a.clock.step(1) 

      a.io.out.expect(true.B)
    }
  }
}
