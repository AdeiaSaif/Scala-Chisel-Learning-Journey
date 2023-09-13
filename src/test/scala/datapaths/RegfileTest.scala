// package datapaths
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class RegfileTest extends FreeSpec with ChiselScalatestTester{
//     "Chisel Tester file " in{
//         test(new Regfile){a =>
//             a.io.rs1.poke(2.U)
//             a.io.rs2.poke(3.U)
//             a.io.rd.poke(1.U)
//             a.io.data.poke(0.U)
//             a.clock.step(5)
//             a.io.d1.expect(0.U)
//             a.io.d2.expect(0.U)

        
//         }
//     }
// }