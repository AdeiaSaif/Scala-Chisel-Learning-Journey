package lab4
import chisel3._
import chisel3.util._
object ALUPOimm{
    val ALU_I="b0010011".U(32.W)
    val ALU_S="b0100011".U(32.W)
    val ALU_B="b1100011".U(32.W)
    val ALU_U="b0110111".U(32.W)
    val ALU_L="b0000011".U(32.W)
    val ALU_J="b1100111".U(32.W)

}
object ALUPOins{
    val ALU_i="b00000000010100000000000010010011".U(32.W)//li x1,5
    val ALU_s="b00000000000100001000000000100011".U(32.W)
    // li x1 4
    // sb x1,0(x1)
    val ALU_b="b00000000001000001001010001100011".U(32.W)
    // li x1,2
    // li x2,2
    // bne x1, x2 label
    // li x3,2
    // label:
    val ALU_u="b00000000000000001100000010110111".U(32.W)
    //lui x1,12
    val ALU_l="b00000000000000001000000100000011".U(32.W)
    // li x1,2
    // sb x1,0(x1)
    // lb x2,0(x1)
    val ALU_j="b00000000010000000000000001101111".U(32.W)
    // j end
    // end:
}
import ALUPOimm._
class imm extends Module{
    var io =IO(new Bundle{
        val ins=Input(UInt(32.W))
        val imm=Output(UInt(32.W))
    })
    io.imm:=0.U
     switch(io.ins(6,0)){
        is(ALU_I){    //I-format
            io.imm:= Cat(Fill(20,0.U),io.ins(31,20))
        }
        is(ALU_S){      //S-format
            io.imm:= Cat(Fill(20,0.U),Cat(io.ins(31,24),io.ins(12,7)))
        }
        is(ALU_B){      //B-format
            io.imm:= Cat(Fill(20,0.U),Cat(Cat(io.ins(31),io.ins(7)),Cat(io.ins(30,26),io.ins(11,8))))
        }
        is(ALU_U){      //U-format
            io.imm:= Cat(Fill(12,0.U),io.ins(19,0))
        }
        is(ALU_L){      //L-format
            io.imm:= Cat(Fill(20,0.U),io.ins(31,20))
        }
        is(ALU_J){      //J-format
            io.imm:= Cat(Fill(20,0.U),Cat(Cat(io.ins(31),io.ins(30,21)),Cat(io.ins(20),io.ins(19,12))))
            
        }
     }
}