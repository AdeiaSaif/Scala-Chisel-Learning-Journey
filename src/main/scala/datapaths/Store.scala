package datapaths
import chisel3._
import chisel3.util._

object Store_Fun3 {
   
    val ALU_SB = 0.U(4.W)
    val ALU_SH = 1.U(4.W)
    val ALU_SW = 2.U(4.W)
}
import Store_Fun3._
class Store extends Module{
    val io=IO(new Bundle{
        val fun3=Input(UInt(3.W))
        val din=Input(SInt(32.W))
        val dout=Output(SInt(32.W))
    })
    io.dout:=0.S
    when(io.fun3===ALU_SB){
        io.dout:=(io.din(6,0)).asSInt
    }
    when(io.fun3===ALU_SH){
        io.dout:=(io.din(14,0)).asSInt
    }
    when(io.fun3===ALU_SW){
        io.dout:=(io.din).asSInt
    }
    
}
    
