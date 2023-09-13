// package datapaths
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class ControlUnitTest extends FreeSpec with ChiselScalatestTester {
//   "Chisel Tester file " in {
//     test(new controlunit) { a =>
//       a.io.ins.poke("b01000000001000001000000110110011".U)
//       a.clock.step(1)
//       a.io.rs1.expect(1.U)
//       a.io.rs2.expect(2.U)
//       a.io.rd.expect(3.U)
//       a.io.op.expect(8.U)
//     }
//   }
// }
