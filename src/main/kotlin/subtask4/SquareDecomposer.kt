package subtask4

import java.util.*

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        var cnSquare = 0L
        val result = Stack<Int>()
        result.add(number)
        while (result.isNotEmpty()){
            val nToDecompose = result.pop()
            cnSquare += Math.pow(nToDecompose.toDouble(), 2.toDouble()).toLong()
            for(i in nToDecompose - 1 downTo 0){
                val sqI = Math.pow(i.toDouble(), 2.toDouble()).toLong()
                if(cnSquare - sqI > 0){
                    result.push(i)
                    cnSquare -= sqI
                }
                else if(cnSquare - sqI == 0L){
                    result.push(i)
                    return result.reversed().toTypedArray()
                }
            }
        }
        return null
    }
}
