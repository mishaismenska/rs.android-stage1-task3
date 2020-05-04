package subtask6

import java.util.*
import javax.swing.tree.TreeNode
import kotlin.collections.ArrayList

class FullBinaryTrees {

    inner class Node{
        var depth = 0
        var left: Node? = null
        var right: Node? = null
    }

    private fun getTreeAsList(n: Node):ArrayList<Int?>{
        val result = ArrayList<Int?>()
        var root = n
        result.add(0)
        val maxd = n.depth
        val children = ArrayList<Node?>()
        children.add(n.left)
        children.add(n.right)
        var currentLevel = 0
        while(children.isNotEmpty()){
            val newChildren = ArrayList<Node?>()
            for(c in children){
                if(c == null){
                    if(currentLevel != maxd) result.add(null)
                } else{
                    result.add(0)
                    newChildren.add(c.left)
                    newChildren.add(c.right)
                }
            }
            children.clear()
            children.addAll(newChildren)
            newChildren.clear()
            currentLevel++
        }
        return result
    }

    fun generateTrees(n: Int): ArrayList<Node>{
        if(n % 2 == 0) return ArrayList()
        if(n == 1) return arrayListOf(Node())
        val result = ArrayList<Node>()
        for(i in 1..(n-1) step 2){
            val left = generateTrees(i)
            val right = generateTrees(n - 1 - i)
            for(ln in left){
                for(rn in right){
                    val root = Node()
                    root.left = ln
                    root.right = rn
                    root.depth = maxOf(ln.depth, rn.depth) + 1
                    result.add(root)
                }
            }
        }
        return result
    }

    fun stringForNodeCount(count: Int): String {
        val r = generateTrees(count)
        //println("Count is ${r.size}")
        val result = ArrayList<ArrayList<Int?>>()
        for(n in r){
            val l = getTreeAsList(n)
            while (l[l.size - 1] == null){
                l.removeAt(l.size - 1)
            }
            //println(l.toString())
            result.add(l)
        }
        return result.toString()
    }
}