package datapaths
import chisel3._
import chisel3.util._
import chisel3.util.experimental.loadMemoryFromFile

class Top extends Module{
    val io=IO(new Bundle{})
    
    val pc= Module(new PC)
    dontTouch(pc.io)
    val instmem= Module(new mems("C:/Users/Dell/Desktop/scala/input.txt"))
    dontTouch(instmem.io)
    val reg= Module(new Regfile)
    dontTouch(reg.io)
    val alu= Module(new ALU(32))
    dontTouch(alu.io)
    val cu=Module(new controlunit)
    dontTouch(cu.io)
    val dmem=Module(new datamemory)
    dontTouch(cu.io)
    val store=Module(new Store)
    dontTouch(store.io)
    val load=Module(new Load)
    dontTouch(load.io)
    val immgen=Module(new imm)
    dontTouch(immgen.io)
    val jalr=Module(new Jalr)
    dontTouch(jalr.io)

    jalr.io.a:=(pc.io.out).asSInt
    jalr.io.b:=immgen.io.out
    //imm generator
    immgen.io.ins:=instmem.io.dout
    //inst mem

     instmem.io.din:=0.S/////////////
     instmem.io.enb:=cu.io.writereg
     //ins
     
     instmem.io.address:= pc.io.out
     //cu
     cu.io.ins:=instmem.io.dout
     //regfile
     reg.io.rd:=cu.io.rd
     reg.io.rs1:= cu.io.rs1
     reg.io.rs2:=cu.io.rs2
     // R/I=alu_out ,Load= memory to reg , U= cu.LUI
     reg.io.data:= Mux((cu.io.ins(6,0)==="b0110011".U) || (cu.io.ins(6,0)==="b0010011".U),alu.io.alu_out,
         /*load*/  Mux(cu.io.ins(6,0)==="b0000011".U, load.io.din,
                   Mux(cu.io.ins(6,0)==="b0110111".U,immgen.io.out,
                   Mux(cu.io.ins(6,0)==="b0010111".U,(pc.io.out+cu.io.auipc).asSInt,
                   Mux(cu.io.ins(6,0)==="b1101111".U || cu.io.ins(6,0)==="b1100111".U,((pc.io.out).asSInt+(4.S)),
                   Mux(cu.io.ins(6,0)==="b1100011".U,alu.io.alu_out,0.S))))))
                   reg.io.wenb:=cu.io.writereg
                   //alu
                   alu.io.arg_x:= reg.io.d1
                   alu.io.arg_y:= Mux((instmem.io.dout(6,0)==="b0110011".U)|| (instmem.io.dout(6,0)==="b0100011".U ) ||  (instmem.io.dout(6,0)==="b1100011".U ),reg.io.d2,
                   Mux((instmem.io.dout(6,0)==="b0010011".U) ||(instmem.io.dout(6,0)==="b0000011".U) ||(instmem.io.dout(6,0)==="b1100111".U) ,immgen.io.out,0.S))
    alu.io.alu_op := cu.io.op
    alu.io.opcode:=cu.io.ins(6,0)

    //store
    store.io.fun3:=cu.io.op
    store.io.din:=reg.io.d2
    //data memory 
    dmem.io.load:=cu.io.load
    dmem.io.address:=Mux(cu.io.ins(6,0)==="b0000011".U,(alu.io.alu_out).asUInt,
    Mux(cu.io.ins(6,0)==="b0100011".U,(Cat(cu.io.ins(31,25),cu.io.ins(11,7))+(reg.io.d1).asUInt).asUInt,0.U))
    dmem.io.din:=store.io.dout
    dmem.io.enb:=cu.io.writereg
    dmem.io.store:=cu.io.store
     //load
    load.io.fun3:=cu.io.op
    load.io.din:=dmem.io.dout
    
    // pc.io.enb:=cu.io.reg_pc_enb
    pc.io.in:=Mux(instmem.io.dout(6,0)==="b1101111".U,(immgen.io.out).asUInt,//jal
    Mux(instmem.io.dout(6,0)==="b1100011".U,// branch
    Mux(alu.io.alu_out===1.S,(immgen.io.out<<1.U).asUInt,4.U),
    Mux(instmem.io.dout(6,0)==="b1100111".U, ((jalr.io.out).asUInt),4.U)))//jalr
}
