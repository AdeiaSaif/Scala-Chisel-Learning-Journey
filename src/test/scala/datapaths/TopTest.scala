package datapaths
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class TopTest extends FreeSpec with ChiselScalatestTester{
    "Chisel Tester file " in{
        test(new Top){a =>
            a.clock.step(100)


            
            
        }
    }
}