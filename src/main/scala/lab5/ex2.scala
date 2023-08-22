package lab5
import chisel3._
import chisel3.util._

class Io_mux[T<: Data](gen:T) extends Bundle{
    val sel=Input(Bool())
    val in_a=Input(gen)
    val in_b=Input(gen)
    val out=Output(gen)
}
class ex2[T<: Data](genn:T) extends Module{
    val io=IO(new Io_mux(genn))
    io.out:= Mux(io.sel,io.in_a,io.in_b)
}