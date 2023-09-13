// package datapaths
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class memTest extends FreeSpec with ChiselScalatestTester{
//     "Chisel Tester file " in{
//         test(new mems("C:/Users/Dell/Desktop/scala/input.txt")){a =>
//             a.io.address.poke(0.U)
//             // a.io.din.poke(21.U)
//             a.clock.step(1)
//             // a.io.dout.expect(21.U)
            
//         }
//     }
// }