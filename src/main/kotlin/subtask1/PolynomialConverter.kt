package subtask1

import java.lang.StringBuilder

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        if(numbers.isNullOrEmpty()) return null
        val result = StringBuilder()
        for(i in numbers.indices){
            val n = numbers[i]
            if(n != 0) result.apply {
                if(n < 0){
                    append(" - ")
                } else if(i != 0) append(" + ")
                if(Math.abs(n) != 1)
                    append(Math.abs(n))
                if(i != numbers.indices.last)
                    append("x")
                if(i < numbers.size - 2){
                    append("^")
                    append(numbers.size - 1 - i)
                }
            }
        }
        return result.toString()
    }
}
