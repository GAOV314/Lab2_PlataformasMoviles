/**
 * Universidad del Valle de Guatemala
 * Programacion de plataformas moviles
 * Gadiel Ocaña, 231270
 * 30/07/24
 * Clase Calculadora, encargada de hacer las converisones entre tipos y evaluar la expresion
 */
package org.example
import java.util.Stack
import kotlin.math.*

class Calculator {
    /**
     * @return el valor de procedencia
     * @param x caracter del operando a evaluar
     * Se encarga de evaluar los operandos y asignarle su valor de precedencia
     */
    fun priority(x: Char): Int {
        return when (x) {
            '+', '-' -> 1
            '*', '/' -> 2
            '^', '√' -> 3
            else -> -1
        }
    }

    /**
     * @return cadena con expresion postfix
     * @param expression variable que guarda la expresion entrada en consola infix
     * La funcion convierte una expresion infix a postfix
     */
    fun infixToPostfix(expression: String): String {
        val stack = mutableListOf<Char>()
        val result = StringBuilder()
        var i = 0

        while (i < expression.length) {
            val char = expression[i]

            when {
                char.isDigit() -> {
                    // Leer números completos
                    while (i < expression.length && (expression[i].isDigit() || expression[i] == '.')) {
                        result.append(expression[i])
                        i++
                    }
                    result.append(' ')  // Añadir un espacio para separar los números
                    continue
                }
                char == '(' -> stack.add(char)
                char == ')' -> {
                    while (stack.isNotEmpty() && stack.last() != '(') {
                        result.append(stack.removeAt(stack.size - 1)).append(' ')
                    }
                    stack.removeAt(stack.size - 1) // Remove '('
                }
                char in listOf('+', '-', '*', '/', '^') -> {
                    while (stack.isNotEmpty() && priority(char) <= priority(stack.last())) {
                        result.append(stack.removeAt(stack.size - 1)).append(' ')
                    }
                    stack.add(char)
                }
            }
            i++
        }

        while (stack.isNotEmpty()) {
            result.append(stack.removeAt(stack.size - 1)).append(' ')
        }

        return result.toString().trim()
    }



}