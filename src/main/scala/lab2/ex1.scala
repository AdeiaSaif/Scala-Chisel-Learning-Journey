//Exercise 1: In Listing 2.5, find a way to use combinational hardware instead of the pre-defined Mux module as done in Listing 2.4. The IO bundle must remain the same. (Hint: See Listing 2.2 for how to manipulate bits.)

package practice
import chisel3._
import chisel3.util._

class ex1 extends Module{
    val io=IO(new Bundle{
        val a=Input(UInt(32.W) )
        val b=Input(UInt(32.W) )
        val sel=Input(Bool())
        val out=Output(UInt())
    })
    io.out:= (io.a & (~Fill (32 , io.sel.asUInt ) )) | (io.b & Fill (32 , io.sel.asUInt ))
}