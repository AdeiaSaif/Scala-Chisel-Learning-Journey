package lab2
import chisel3._
import chisel3.util._

class task2 extends Module{
    val io =IO(new Bundle{
        val in1=Input(Bool())
        val in2=Input(Bool())
        val in3=Input(Bool())
        val in4=Input(Bool())

        val s0=Input(Bool())
        val s1=Input(Bool())

        val shift=Input(Bool())

        val out0=Output(Bool())
        val out1=Output(Bool())
        val out2=Output(Bool())
        val out3=Output(Bool())
    })
val select=Cat(io.s0,io.s1).asUInt
io.out0:= MuxLookup(select,false.B,Array(
    0.U -> io.in1,
    1.U -> io.in2,
    2.U -> io.in3,
    3.U -> io.in4
)) 

io.out1:= MuxLookup(select,false.B,Array(
    0.U -> io.in1,
    1.U -> io.in2,
    2.U -> io.in3,
    3.U -> Mux(io.shift,io.in1,0.U)
))

io.out2:= MuxLookup(select,false.B,Array(
    0.U -> io.in1,
    1.U -> io.in2,
    2.U -> Mux(io.shift,io.in1,0.U),
    3.U -> Mux(io.shift,io.in2,0.U)
))

io.out3:= MuxLookup(select,false.B,Array(
    0.U -> io.in1,
    1.U -> Mux(io.shift,io.in1,0.U),
    2.U -> Mux(io.shift,io.in2,0.U),
    3.U -> Mux(io.shift,io.in3,0.U)
))

}