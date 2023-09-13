// package datapaths
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class StoreTest extends FreeSpec with ChiselScalatestTester{
//     "Chisel Tester file " in{
//         test(new Store){a =>
//             a.io.din.poke(128.U)
//             a.io.fun3.poke(0.U)
//             a.clock.step(100)
//             a.io.dout.expect(128.U)
       
//         }
//     }
// }