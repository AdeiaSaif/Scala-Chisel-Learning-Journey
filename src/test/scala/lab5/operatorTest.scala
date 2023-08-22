package lab5
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class operatorTest extends FreeSpec with ChiselScalatestTester{
    "Chisel "in{
        test(new operator(6,UInt(16.W))(_+_)){a=>
        a.io.in(0).poke(9.U)    
        a.io.in(1).poke(5.U)
        a.io.in(2).poke(2.U)
        a.io.in(3).poke(1.U)
        a.io.in(4).poke(0.U)
        a.io.in(5).poke(1.U)
        a.clock.step(1)
        a.io.out(0).expect(14.U)
        a.io.out(1).expect(7.U)    
        a.io.out(2).expect(3.U)    
        a.io.out(3).expect(1.U)    
        a.io.out(4).expect(1.U)    
       // a.io.out(5).expect(18.U)    


        }
    }
}