package lab3m
import chisel3._
import chisel3.util._

class imm extends Module{
    var io =IO(new Bundle{
        val ins=Input(UInt(32.W))
        val imm=Output(UInt(32.W))
    })
    io.imm:=0.U
     switch(io.ins(6,0)){
        is("b0010011".U){    //I-format
            io.imm:= Cat(Fill(20,0.U),io.ins(31,20))
        }
        is("b0100011".U){      //S-format
            io.imm:= Cat(Fill(20,0.U),Cat(io.ins(31,24),io.ins(12,7)))
        }
        is("b1100011".U){      //B-format
            io.imm:= Cat(Fill(20,0.U),Cat(Cat(io.ins(31),io.ins(7)),Cat(io.ins(30,26),io.ins(11,8))))
        }
        is("b0110111".U){      //U-format
            io.imm:= Cat(Fill(12,0.U),io.ins(19,0))
        }
        is("b0000011".U){      //L-format
            io.imm:= Cat(Fill(20,0.U),io.ins(31,20))
        }
        is("b1100111".U){      //J-format
            io.imm:= Cat(Fill(20,0.U),Cat(Cat(io.ins(31),io.ins(30,21)),Cat(io.ins(20),io.ins(19,12))))
            
        }
     }
}