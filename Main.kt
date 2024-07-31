/**
 * Universidad del Valle de Guatemala
 * Programacion de plataformas moviles
 * Gadiel Ocaña, 231270
 * 30/07/24
 * Clase main encargada de ejecutar la logica del programa
 */
package org.example

fun main() {
    var loopCondition = true
    var option = 0
    do{
        println("-----Calculadora-----\n1. Calcular expresion\n2. Salir del programa")
        option = readLine()?.toInt()!!

        when(option){
            1 -> {
                println("Ingrese una expresion infix: ")
            var infixExpres: String = readLine().toString()
                val calculator = Calculator()
                var result = calculator.evaluatePostfix(calculator.infixToPostfix(infixExpres))
                println("Resultado: $result")
            }
            else -> {loopCondition = false
                println("Saliendo del programa...")
            }
        }

    }while (loopCondition)
}