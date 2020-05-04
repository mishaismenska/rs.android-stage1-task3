package subtask2

class Combinator {

    private fun factorial(n: Int): Long{
        var result = 1L
        for(i in 1..n){
            result *= i
        }
        return result
    }

    fun checkChooseFromArray(array: Array<Int>): Int? {
        var result = 0
        var n = 1L
        for(k in 1..array[1]){
            n*= (array[1] - k + 1)
            if(n /factorial(k) >= array[0]){
                return k
            }
        }
        return null
    }
}
