package practice
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class task3test extends FreeSpec with ChiselScalatestTester{
    "Chisel test task3" in{
        test(new task3(1,15)){a=>
        a.clock.step(100)
        a.io.result.expect(1.B)    
        }
    }
}