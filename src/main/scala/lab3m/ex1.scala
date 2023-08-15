//Refer to Listing 3.3, implement 4 to 2 encoder using switch-is statements.
package lab3m
import chisel3._
import chisel3.util._
class ex1 extends Module{
    var io=IO(new Bundle{
        var in=Input(UInt(4.W))
        var out=Output(UInt(2.W))
    })
    io.out := 0.U
    switch(io.in){
        is ("b0001".U){
            io.out:= 0.U
        }
        is ("b0010".U){
            io.out:= 1.U
        }
        is ("b0100".U){
            io.out:= 2.U
        }
        is ("b1000".U){
            io.out:= 3.U
        }
    }
}