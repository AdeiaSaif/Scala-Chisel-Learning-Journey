package lab5
import chisel3._
import chisel3.util._

object ALUOP {
    val ALU_ADD = 0.U(4.W)
    val ALU_SUB = 1.U(4.W)
    val ALU_AND = 2.U(4.W)
    val ALU_OR  = 3.U(4.W)
    val ALU_XOR = 4.U(4.W)
    val ALU_SLT = 5.U(4.W)
    val ALU_SLL = 6.U(4.W)
    val ALU_SLTU= 7.U(4.W)
    val ALU_SRL = 8.U(4.W)
    val ALU_SRA = 9.U(4.W)
    val ALU_COPY_A = 10.U(4.W)
    val ALU_COPY_B = 11.U(4.W)
    val ALU_XXX = 12.U(4.W) 
}

import ALUOP._
class IO_Interface(widthio:Int) extends Bundle{
    val alu_op=Input(UInt(widthio.W))
    val arg_x=Input(UInt(widthio.W))
    val arg_y=Input(UInt(widthio.W))
    val alu_out=Output(UInt(widthio.W))
}

class ALU(width:Int) extends Module{
    var io=IO(new IO_Interface(width))
    io.alu_out:=0.U
    when(io.alu_op===ALU_ADD){
        io.alu_out:=io.arg_x+io.arg_y
    }
    .elsewhen(io.alu_op===ALU_SUB){
        io.alu_out:=io.arg_x-io.arg_y
    }
     .elsewhen(io.alu_op===ALU_AND){
        io.alu_out:=io.arg_x&io.arg_y
    } 
    .elsewhen(io.alu_op===ALU_OR){
        io.alu_out:=io.arg_x|io.arg_y
    }
     .elsewhen(io.alu_op===ALU_XOR){
        io.alu_out:=io.arg_x^io.arg_y
    }
     .elsewhen(io.alu_op===ALU_SLT){
        io.alu_out:=(io.arg_x<io.arg_y)
    } 
    .elsewhen(io.alu_op===ALU_SLL){
        io.alu_out:=(io.arg_x<<io.arg_y(4,0))
    } 
     .elsewhen(io.alu_op===ALU_SLTU){
        io.alu_out:=(io.arg_x<io.arg_y)
    } 
     .elsewhen(io.alu_op===ALU_SRL){
        io.alu_out:=(io.arg_x>>io.arg_y(4,0))
    } 
     .elsewhen(io.alu_op===ALU_SRA){
        io.alu_out:=(io.arg_x>>io.arg_y(4,0))
    } 
     .elsewhen(io.alu_op===ALU_COPY_A){
        io.alu_out:=io.arg_x
    } 
    .elsewhen(io.alu_op===ALU_COPY_B){
        io.alu_out:=io.arg_y
    } 
    .otherwise{
        io.alu_out:=0.U
    }
}