package lab5
import chisel3._

class operator[T<: Data](n:Int, gen: T)(op: (T,T)=>T) extends Module{
    require(n>0)
    val io=IO(new Bundle{
        val in=Input(Vec(n,gen))
        val out=Output(Vec(n-1,gen))
    })
    for (i <- 0 until n-1) {
        io.out(i):= op(io.in(i),io.in(i+1))
        
    }
}