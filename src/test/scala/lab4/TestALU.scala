package lab4
import chisel3._
import chisel3.tester._
import chisel3.util._
import org.scalatest._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import scala.util.Random
import ALUOP._


class TestALU extends FreeSpec with ChiselScalatestTester{
    "ALU test "in{
        test(new lab3m.ex2) {c=>
            val array_op=Array(ALU_ADD,ALU_SUB,ALU_AND,ALU_OR,ALU_XOR,ALU_SLT,ALU_SLL,ALU_SLTU,ALU_SRL,ALU_SRA,ALU_COPY_A,ALU_COPY_B)   

        for(i<-0 until 1){
            val src_a = Random.nextLong() & 0xFFFFFFFFL

            val src_b = Random.nextLong() & 0xFFFFFFFFL

            val opr=Random.nextInt(11)
            val aluop=array_op(opr)

            val result = aluop match {
                case ALU_ADD=> src_a+src_b
                case ALU_SUB=> src_a-src_b
                case ALU_AND=> src_a&src_b
                case ALU_OR=> src_a|src_b
                case ALU_XOR=> src_a^src_b
                case ALU_SLT=>  if((src_a<src_b))1 else 0       
                case ALU_SLL=> src_a<<(src_b &0x1F)
                case ALU_SLTU => if(src_a<src_b)1 else 0  
                case ALU_SRL=> src_a>>(src_b &0x1F)
                case ALU_SRA=> src_a>>(src_b &0x1F)
                case ALU_COPY_A=> src_a
                case ALU_COPY_B=> src_b
                case _ => 0

            
            }
            val result1: BigInt = if (result < 0L)
  (BigInt(0xFFFFFFFFL) + result + 1) & 0xFFFFFFFFL
else
  result & 0xFFFFFFFFL
            c.io.A.poke(src_a.U)
            c.io.B.poke(src_b.U)
            c.io.Opcode.poke(aluop)
            c.clock.step(1)
            c.io.out.expect(result1.asUInt)
            // println(":==="+c.io.in_A.peek())
            // println(c.io.in_B.peek())
            // println(c.io.alu_Op.peek())
            // println(c.io.out.peek())

        }         
        c.clock.step(2)
        }
    }
}