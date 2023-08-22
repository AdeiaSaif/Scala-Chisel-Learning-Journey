package lab5
import chisel3._
class eMux[T<: Data](in1: T, in2:T, out:T) extends Module{
    val io=IO(new Bundle{
        val inp1=Input(in1)
        val inp2=Input(in2)
        val outp=Output(out)
        val sel=Input(Bool())
    })
    io.outp:= Mux(io.sel,io.inp1,io.inp2)
}