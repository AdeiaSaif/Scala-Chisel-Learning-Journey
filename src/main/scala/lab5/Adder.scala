package lab5
import chisel3._
class Adder(w:Int) extends Module{
    require(w>=0)
    var io=IO(new Bundle{
        var in0=Input(UInt(w.W))
        var in1=Input(UInt(w.W))
        var sum=Output(UInt(w.W))
    })
    io.sum:= io.in0+io.in1
}