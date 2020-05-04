package subtask5

import kotlin.reflect.KClass

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if(number.toInt() < 0) return null
        val neighbours = hashMapOf<Char, ArrayList<Char>>(
            '1' to arrayListOf('2', '4'),
            '2' to arrayListOf('1', '5', '3'),
            '3' to arrayListOf('2', '6'),
            '4' to arrayListOf('1', '5', '7'),
            '5' to arrayListOf('2', '4', '6', '8'),
            '6' to arrayListOf('3', '5', '9'),
            '7' to arrayListOf('4', '8'),
            '8' to arrayListOf('7', '5', '9', '0'),
            '9' to arrayListOf('6', '8'),
            '0' to arrayListOf('8')
        )
        val result = ArrayList<String>()
        for((i, c) in number.withIndex()){
            for(n in neighbours[c]!!){
                result.add(number.substring(0, i) + n + number.substring(i + 1))
            }
        }
        return result.toTypedArray()
    }
}
