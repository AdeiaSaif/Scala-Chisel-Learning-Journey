package lab3m
import chisel3 . _
import chisel3 . util . _
class LM_IO_Interface_BranchControl extends Bundle {
val fnct3 = Input ( UInt (3. W ) )
val branch = Input ( Bool () )
val A = Input ( UInt (32. W ) )
val B = Input ( UInt (32. W ) )
val out = Output ( Bool () )
}
class BranchControl extends Module {
val io = IO (new LM_IO_Interface_BranchControl )
io.out:=0.U

when(io.branch===true.B){
    when(io.fnct3===0.U){
        io.out:= io.A===io.B
    }
    .elsewhen(io.fnct3===1.U){
        io.out:= (io.A=/=io.B)
    }
    .elsewhen(io.fnct3===4.U){
        io.out:= (io.A<io.B)
    }
    .elsewhen(io.fnct3===5.U){
        io.out:= (io.A>=io.B)
    }
    .elsewhen(io.fnct3===6.U){
        io.out:= (io.A<io.B)
    }
    .elsewhen(io.fnct3===7.U){
        io.out:= (io.A>=io.B)
    }
}

}
