// package datapaths
// import chisel3._
// import chisel3.util._

// class MemMask extends Module {
// val io = IO (new Bundle {
// val enable = Input ( Bool () )
// val write = Input ( Bool () )
// val addr = Input ( UInt (10. W ) )
// val mask = Input ( Vec (4 , Bool () ) )
// val dataIn = Input ( Vec (4 , UInt ( 32 . W ) ) )
// val dataOut = Output ( Vec (4 , UInt ( 32 . W ) ) )
// })
// val mem = SyncReadMem (1024 , Vec (4 , UInt ( 32 . W ) ) )
// // Write with mask
// when(io.mask===0.U){  
//         io.addr(7,0):=io.dataIn(7,0)
// }
// when(io.mask===1.U){  
//         io.addr(7,0):=io.dataIn(7,0)
// }when(io.mask===2.U){  
//         io.addr(7,0):=io.dataIn(7,0)
// }when(io.mask===3.U){  
//         io.addr(7,0):=io.dataIn(7,0)
// }
// }