package DynamicProblem

import java.util.*
import java.util.*
import kotlin.io.*
import kotlin.math.max
import kotlin.ranges.*
import kotlin.text.*

// Complete the abbreviation function below.
lateinit var ar: Array<Array<Boolean>>
lateinit var vis: Array<Array<Boolean>>
val reg = Regex("^[a-z]+\$")
fun abbreviation(a: String, b: String): Int {

    if ((a.isEmpty() && b.isEmpty()) || (b.isEmpty() && a.contains(reg))) {
        return 1
    } else if ((a.isEmpty() && !b.isEmpty()) || ((b.isEmpty() && !a.contains(
            reg
        ))) || (a.last().isUpperCase() && a.last() != b.last())
    ) {
        return 0
    }
    return 2
}

fun recur(a: String, b: String): Boolean {
    if (vis[a.length][b.length])
        return ar[a.length][b.length]
    if (abbreviation(a, b) == 1)
        return true
    if (abbreviation(a, b) == 0)
        return false
    else {

        var a = a
        var b = b
        var b1: String = ""
        var lastA = a.last()
        if (a.last().isLowerCase()) {
            a = a.dropLast(1)
            if (lastA.toUpperCase() == b.last()) {
                ar[a.length][b.length] = recur(a, b)
                vis[a.length][b.length] = true
                ar[a.length][b.length - 1] = recur(a, b.dropLast(1))
                vis[a.length][b.length-1] = true
                return ar[a.length][b.length] || ar[a.length][b.length - 1]
            } else {

                ar[a.length][b.length] = recur(a, b)
                vis[a.length][b.length] = true

                return ar[a.length][b.length]
            }

        } else {
            if (a.last() == b.last()) {
                a = a.dropLast(1)
                b = b.dropLast(1)
            }
            ar[a.length][b.length] = recur(a, b)
            vis[a.length][b.length] = true
            return ar[a.length][b.length]
        }

    }
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val a = scan.nextLine()

        val b = scan.nextLine()
        ar = Array(1001) { Array(1001) { false } }
        vis = Array(1001) { Array(1001) { false } }
        val result = recur(a, b)

        if (result)
            println("YES")
        else
            println("NO")
    }
}
