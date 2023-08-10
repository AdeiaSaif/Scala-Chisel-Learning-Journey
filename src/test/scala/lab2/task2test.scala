package lab2
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class task2test extends FreeSpec with ChiselScalatestTester {
  "Chisel" in {
    test(new task2) { a =>
        a.io.in1.poke(true.B) 
      a.io.in2.poke(false.B) 
      a.io.in3.poke(true.B)
      a.io.in4.poke(false.B) 

      a.io.s0.poke(false.B) 
      a.io.s1.poke(false.B)  

      a.io.shift.poke(true.B) 

      a.clock.step(1) 

      a.io.out0.expect(true.B)
      a.io.out1.expect(true.B)
      a.io.out2.expect(true.B)
      a.io.out3.expect(true.B)
    }
  }
}
