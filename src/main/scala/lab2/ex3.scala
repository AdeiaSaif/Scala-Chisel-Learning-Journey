package lab2
import chisel3._
import chisel3.util._

class IOs extends Bundle{
    val a=Input(UInt(4.W))
    val b=Input(UInt(4.W))
    val c=Input(UInt(4.W))
    val d=Input(UInt(4.W))
    val s=Input(UInt(4.W))
    val out=Output(UInt(2.W))
}

class ex3 extends Module{
    val io=IO(new IOs)
    io.out:=Mux1H(io.s,Seq(io.a,io.b,io.c,io.d))
}