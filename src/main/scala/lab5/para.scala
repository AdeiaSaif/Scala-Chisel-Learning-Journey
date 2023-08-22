package lab5
import chisel3._

class t_in[T<: Data](typ: T) extends Bundle{
    val address=Input(UInt(32.W))
    val data=typ.cloneType
    val valid= Input(Bool())
}
class t_out[T<: Data](typ: T) extends Bundle{
    val address=Input(UInt(32.W))
    val data=typ.cloneType
    val valid= Input(Bool())
}
class rou[T<: Data](typ: T) extends Module{
    val io=IO(new Bundle{
        val in=Input(new t_in(typ))
        val out=Output(new t_out(typ))
    })
    io.out.data := 0.U
    io.out.address :=0.U
    io.out.valid:=0.U
    when (io.in.valid){
        io.out.data := io.in.data
        io.out.address := io.in.address
        io.out.valid:=io.in.valid
    }
}