package lab4
import chisel3._ 
import chisel3.util._ 


object ALUOPs {
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
    val ALU_beq=13.U(4.W)
    val  ALU_bne=14.U(4.W)
    val  ALU_blt=15.U(4.W)
    val  ALU_bge=16.U(5.W)
}

trait Configs{
    val WLEN = 32
    val ALUOP_SIG_LEN = 5
}

import ALUOPs._

class ALUIOO extends Bundle with Config {
    val in_A = Input(UInt(WLEN.W))
    val in_B = Input(UInt(WLEN.W))
    val alu_Op = Input(UInt(ALUOP_SIG_LEN.W))
    val out = Output(UInt(WLEN.W))
    val sum = Output(UInt(WLEN.W))
}

class ex1 extends Module with Configs {
    val io = IO(new ALUIOO)

    val sum = io.in_A + Mux(io.alu_Op(0), io.in_B, -io.in_B)
    val cmp = Mux(io.in_A(WLEN-1) === io.in_B(WLEN-1), sum(WLEN-1),
                Mux(io.alu_Op(1), io.in_A(WLEN-1), io.in_B(WLEN-1)))
    val shamt = io.in_A(4,0).asUInt
    val shin = Mux(io.alu_Op(3), Reverse(io.in_A), io.in_A)
    val shiftr = (Cat(io.alu_Op(0) & shin, shin(WLEN-1)).asSInt >> shamt)(WLEN-1,0)
    val shitfl = Reverse(shiftr)
    val out = 
    Mux(io.alu_Op === ALU_ADD | io.alu_Op === ALU_SUB, sum, 
    Mux(io.alu_Op === ALU_SLT | io.alu_Op === ALU_SLTU, cmp, 
    Mux(io.alu_Op === ALU_SRA | io.alu_Op === ALU_SRL, shitfl,
    Mux(io.alu_Op === ALU_SLL, shiftr, 
    Mux(io.alu_Op === ALU_AND, (io.in_A & io.in_B),
    Mux(io.alu_Op === ALU_OR, (io.in_A | io.in_B),
    Mux(io.alu_Op === ALU_XOR, (io.in_A ^ io.in_B),
    Mux(io.alu_Op === ALU_COPY_A, io.in_A, 
    Mux(io.alu_Op === ALU_COPY_B, io.in_A, 
    Mux(io.alu_Op === ALU_beq, (io.in_A===io.in_B),
    Mux(io.alu_Op ===  ALU_bne, (io.in_A=/=io.in_B),
    Mux(io.alu_Op ===  ALU_blt, (io.in_A<io.in_B),
    Mux(io.alu_Op ===  ALU_bge, (io.in_A>=io.in_B), 0.U)))))))))))))


    io.out := out
    io.sum := sum
}
