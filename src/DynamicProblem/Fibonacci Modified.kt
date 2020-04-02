package DynamicProblem

import java.math.BigInteger

import java.util.*
import kotlin.io.*
import kotlin.math.max
import kotlin.ranges.*
import kotlin.text.*

// Complete the DynamicProblem.fibonacciModified function below.
fun fibonacciModified(t1: Int, t2: Int, n: Int): BigInteger {
    var t1 = t1.toBigInteger()
    var t2 = t2.toBigInteger()
    var t3: BigInteger = BigInteger.ZERO
    for (i in 1..n - 2) {
        t3 = t2.pow(2) + t1
        t1 = t2
        t2 = t3

    }
    return t3

}

fun fibonacciWithString(t1: Int, t2: Int, n: Int): String {
    var t1 = t1.toString()
    var t2 = t2.toString()
    var t3 = 0.toString()
    for (i in 1..n - 2) {
        t3 = add(mul(t2, t2), t1)
        t1 = t2
        t2 = t3

    }
    return t3

}
fun add(s1: String, s2: String): String {
    if(s1.isEmpty()||s2.isEmpty()){
        return if(s1.isEmpty())s2 else s1
    }
    var i = 0
    var j = 0
    var s1 = s1
    var s2 = s2
    s1 = s1.reversed()
    s2 = s2.reversed()
    var mx = max(s1.length, s2.length)
    for (i in s1.length - 1..mx - 2) {
        s1 += '0'
    }
    for (i in s2.length - 1..mx - 2) {
        s2 += '0'
    }

    var to = ""
    var c = 0
    while (i < s1.length && j < s2.length) {
        var sum = ((s1[i] - '0') + (s2[j] - '0') + c).toString()
        if (sum.length > 1) {
            to += sum[1]
            c = 1
        } else {
            to += sum[0]
            c = 0
        }
        i++
        j++
    }
    to = to.reversed()
   // println(to)
    return to

}

fun mul(s1: String, s2: String):String {
    var i = 0
    var j = 0
    var s1 = s1
    var s2 = s2
    s1 = s1.reversed()
    s2 = s2.reversed()


    var to = ""
    var total = ""
    var c = 0
    for (i in 0 until s1.length) {
        to=""
        c=0
        for (j in 0 until s2.length) {
            var sum = ((s1[i] - '0') * (s2[j] - '0') + c).toString()
            if (sum.length > 1) {
                to += sum[1]
                c = sum[0] - '0'
            } else {
                to += sum[0]
                c = 0
            }
        }
        if (c != 0)
            to += c.toString()
        to=to.reversed()
        for(ii in 0 until i)
            to+='0'
        total = add(to, total)
    }
   // to = to.reversed()
  //  println(total)
    return total

}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    var t1T2n = scan.nextLine().split(" ")

    var t1 = t1T2n[0].trim().toInt()

    var t2 = t1T2n[1].trim().toInt()

    val n = t1T2n[2].trim().toInt()

     val result = fibonacciModified(t1, t2, n)

     println(result)
   // DynamicProblem.mul("1111117788777777888", "1210000000000")
}
