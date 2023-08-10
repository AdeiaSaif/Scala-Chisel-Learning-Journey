package lab2
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class task1test extends FreeSpec with ChiselScalatestTester {
  "Chisel" in {
    test(new task1) { a =>
      a.io.s0.poke(1.U) 
      a.io.s1.poke(1.U) 
      a.io.s2.poke(1.U) 
      a.clock.step(1) 

      a.io.out.expect(32.U)
    }
  }
}
