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



}