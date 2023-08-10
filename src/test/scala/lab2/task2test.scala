package lab2
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class task2test extends FreeSpec with ChiselScalatestTester {
  "Chisel" in {
    test(new task2) { a =>
        a.io.in(0).poke(false.B) 
      a.io.in(1).poke(false.B) 
      a.io.in(2).poke(true.B)
      a.io.in(3).poke(false.B) 

      a.io.s(0).poke(false.B) 
      a.io.s(1).poke(true.B)  

      a.io.shift.poke(true.B) 

      a.clock.step(1) 

      a.io.out(0).expect(false.B)
      a.io.out(1).expect(false.B)
      a.io.out(2).expect(false.B)
      a.io.out(3).expect(false.B)
    }
  }
}
