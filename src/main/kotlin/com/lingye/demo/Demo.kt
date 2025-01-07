package com.lingye.demo

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class Demo() {
    init {
        println("232")
    }

    fun test() {

    }
}

fun main() {
    val ans = ArrayList<Int>(2)
//    val on = BooleanArray(2)
//    val onPath = BooleanArray(2) {false}

    ans.add(2)
    ans.add(3)
    ans.add(4)
    val ans2 = ArrayList(ans)

    ans.add(5)

    ans.forEach { println(it + 100) }

    val set = HashSet<Int>()
    val nums = IntArray(5) { -1 }
    nums.sum()
    nums.max()

    for ((index, value) in nums.withIndex()) {
    }

    val list = buildList {
        for (i in nums) {
            add(i)
        }
    }
    list.toMutableList()

    val map = HashMap<Int, Int>()
    val item = map[1] ?: -1

    val stack = Stack<Int>()
    val deque: Deque<Int> = LinkedList<Int>()
    deque.pollLast()
    deque.peek()

    val ans212 = if(stack.isEmpty()) 1 else 2

    for (i in 10 downTo 20) {
        println("hello")
    }

    val dp = Array(10) { i ->
        if (i == 0)
            IntArray(5) {Int.MAX_VALUE / 2}
        else
            IntArray(5)
    }

    println(dp)

    val str = "hell"
    val str2 = "he"
    val tree = HashMap<Int, ArrayList<Int>>()
    val list12 = tree[0] ?: ArrayList<Int>()
    tree[0] = list12
}