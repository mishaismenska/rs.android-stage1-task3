package subtask3

import java.util.*

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val items = itemsFromArray.filterIsInstance<Int>().sortedByDescending { Math.abs(it) }.toTypedArray()
        if(items.isEmpty()) return 0
        val N = if(numberOfItems >= items.size) items.size else numberOfItems
        var result = 1
        var negativesInNCount = 0
        var lastNegative: Int? = null
        var lastPositive:Int? = null
        var firstPositive:Int? = null
        var firstNegative:Int? = null
        for((i, item) in items.withIndex()){
            if(item < 0) {
                if(i < N){
                    negativesInNCount++
                    lastNegative = i
                }
                else if(firstNegative == null) firstNegative = i
            } else {
                if(i < N) lastPositive = i
                else if(firstPositive == null) firstPositive = i
            }
        }
        if(negativesInNCount % 2 != 0){
            val e1 = !((lastNegative == null || firstPositive == null))
            val e2 = !(lastPositive == null || firstNegative == null)
            if(!e1 && !e2){
                for(i in items.size - N..items.indices.last){
                    result *= items[i]
                }
                return result
            } else if(e1 && e2){
                if(items[lastPositive!!] * items[firstPositive!!] > items[lastNegative!!] * items[firstNegative!!]){
                    items[lastNegative!!] = items[firstPositive!!].also { items[firstPositive] = items[lastNegative] }
                } else{
                    items[lastPositive!!] = items[firstNegative!!].also { items[firstNegative] = items[lastPositive] }
                }
            }
            else if(e1){
                items[lastNegative!!] = items[firstPositive!!].also { items[firstPositive] = items[lastNegative] }
            } else if(e2){
                items[lastPositive!!] = items[firstNegative!!].also { items[firstNegative] = items[lastPositive] }
            }
        }
        for(i in 0 until N){
            result *= items[i]
        }
        return result
    }


}