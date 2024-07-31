/**
 * Universidad del Valle de Guatemala
 * Programacion de plataformas moviles
 * Gadiel Ocaña, 231270
 * 30/07/24
 * Clase de los unitTest de la calculadora
 */
import org.example.Calculator
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


class TestCalculator {

    private lateinit var calculator: Calculator

    @BeforeTest
    fun setup() {
        calculator = Calculator()
    }

    @Test
    fun testInfixToPostfix() {
        assertEquals("3 2 1 - 6 * + 3 -", calculator.infixToPostfix("3 + (2 -1)*6 - 3"))
    }

    @Test
    fun testPostfixEvaluator() {
        assertEquals(6.0, calculator.evaluatePostfix("3 2 1 - 6 * + 3 -"))
    }

    @Test
    fun testPrecedence() {
        assertEquals(3, calculator.priority('^'))
    }
}
