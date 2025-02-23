package lab3m
import chisel3 . _
import chisel3 . util . _
class LM_IO_Interface_decoder_with_valid extends Bundle {
    val in = Input ( UInt (2. W ) )
    val out = Valid ( Output ( UInt (4. W ) ) )
}
class as3 extends Module {
    val io = IO (new LM_IO_Interface_decoder_with_valid )
    io.out.bits:=0.U
    io.out.valid:=false.B
    switch(io.in){
        is("b00".U){
            io.out.bits:="b0001".U
            io.out.valid:=true.B
        }
         is("b01".U){
            io.out.bits:="b0010".U
            io.out.valid:=true.B
        } 
        is("b10".U){
            io.out.bits:="b0100".U
            io.out.valid:=true.B
        }
         is("b11".U){
            io.out.bits:="b1000".U
            io.out.valid:=true.B
        }
    }
}
