package datapaths
import chisel3._
import chisel3.util._

class Jalr extends Module{
    val io=IO(new Bundle{
        val a=Input(SInt(32.W))
        val b=Input(SInt(32.W))
        val out=Output(SInt(32.W))
    })
    val reg=Reg(SInt(32.W))
    reg:=(io.a+io.b) & "hfffffffe".U
    io.out:=reg 
}