package lab4
import chisel3._
import chisel3.util._
object ALUPOb{
    val ALU_Beq=0.U(3.W)
    val ALU_Bne=1.U(3.W)
    val ALU_Blt=4.U(3.W)
    val ALU_Bge=5.U(3.W)
    val ALU_Bltu=6.U(3.W)
    val ALU_Bgeu=7.U(3.W)
}
class LM_IO_Interface_BranchControl extends Bundle {
  val fnct3 = Input(UInt(3.W))
  val branch = Input(Bool())
  val A = Input(UInt(32.W))
  val B = Input(UInt(32.W))
  val out = Output(UInt(1.W))
}
class BranchControl extends Module {
  val io = IO(new LM_IO_Interface_BranchControl)
  io.out := 0.U

  when(io.branch === true.B) {
    when(io.fnct3 === 0.U) {
      io.out := io.A === io.B
    }
      .elsewhen(io.fnct3 === 1.U) {
        io.out := (io.A =/= io.B)
      }
      .elsewhen(io.fnct3 === 4.U) {
        io.out := (io.A < io.B)
      }
      .elsewhen(io.fnct3 === 5.U) {
        io.out := (io.A >= io.B)
      }
      .elsewhen(io.fnct3 === 6.U) {
        io.out := (io.A < io.B)
      }
      .elsewhen(io.fnct3 === 7.U) {
        io.out := (io.A >= io.B)
      }
  }

}
