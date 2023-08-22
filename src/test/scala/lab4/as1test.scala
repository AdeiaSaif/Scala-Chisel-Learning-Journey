package lab4
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import scala.util.Random
import ALUPOb._

class as1test extends FreeSpec with ChiselScalatestTester{
    "Chisel " in{
        test(new BranchControl){a=>
            val array_op=Array(ALU_Beq,ALU_Bne,ALU_Blt,ALU_Bge,ALU_Bltu,ALU_Bgeu)
            for(i<-0 until 100){
                val As=Random.nextInt(32)
                val Bs=Random.nextInt(32)
                val fncts3=Random.nextInt(3)
                val branchs=Random.nextInt(1)
                val fnc=array_op(fncts3)
                
                val result= fnc match{
                    case ALU_Beq=> if(As===Bs)1 else 0
                    case ALU_Bne=> if(As!=Bs)1 else 0
                    case ALU_Blt=> if(As<Bs)1 else 0
                    case ALU_Bge=> if(As>=Bs)1 else 0
                    case ALU_Bltu=> if(As<Bs)1 else 0
                    case ALU_Bgeu=> if(As>=Bs)1 else 0
                    case _ => 0
                }

            a.io.branch.poke(true.B)
            a.io.fnct3.poke(fnc)
            a.io.A.poke(As.U)
            a.io.B.poke(Bs.U)
            a.clock.step(1)
            a.io.out.expect(result.U)
            }
            a.clock.step(1)

        }
    }
}