package datapaths
import chisel3._
import chisel3.util._

object Load_Fun3 {
   
    val ALU_LB = 0.U(4.W)
    val ALU_LH = 1.U(4.W)
    val ALU_LW = 2.U(4.W)
    val ALU_LBU = 4.U(4.W)
    val ALU_LHU = 5.U(4.W)
}
import Load_Fun3._
class Load extends Module{
    val io=IO(new Bundle{
        val fun3=Input(UInt(3.W))
        val din=Input(SInt(32.W))
        val dout=Output(SInt(32.W))
    })
    io.dout:=0.S
    when(io.fun3===ALU_LB){
        io.dout:=Cat(Fill(26,io.din(7)),io.din(7,0)).asSInt
    }
    when(io.fun3===ALU_LH){
        io.dout:=Cat(Fill(16,io.din(15)),io.din(15,0)).asSInt
    }
    when(io.fun3===ALU_LW){
        io.dout:=(io.din).asSInt
    }
    when(io.fun3===ALU_LBU){
        io.dout:=Cat(Fill(26,0.U),io.din(6,0).asUInt).asSInt
    }
    when(io.fun3===ALU_LHU){
        io.dout:=Cat(Fill(16,0.U),io.din(14,0).asUInt).asSInt
    }
}
    
