package lab2
import chisel3._
import chisel3.util._
class task1 extends Module{
    val io=IO(new Bundle{
        val s0=Input(UInt(1.W))
        val s1=Input(UInt(1.W))
        val s2=Input(UInt(1.W))
        val out=Output(UInt(32.W))
    })
    val conc= Cat(io.s0,io.s1,io.s2)
    io.out:= MuxLookup(conc,0.U,Array(
        "b000".U -> 0.U,
        "b001".U -> 8.U,
        "b010".U -> 16.U,
        "b011".U -> 24.U,
        "b111".U -> 32.U
    ))
}