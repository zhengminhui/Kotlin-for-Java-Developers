package mastermind

import java.util.LinkedList

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val solutionList = LinkedList<Char>()
    secret.forEach { solutionList.add(it) }
    var real = 0
    var fake = 0
    for (i in secret.indices) {
        if (guess[i] == secret[i]) {
            real++
            if (!solutionList.remove(guess[i])) {
                fake--
            }
        } else {
            if (solutionList.contains(guess[i])) {
                fake++
                solutionList.remove(guess[i])
            }
        }
    }
    return Evaluation(real, fake)
}
