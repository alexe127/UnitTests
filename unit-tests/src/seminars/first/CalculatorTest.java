package seminars.first;

import seminars.first.model.Calculator;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorTest {
    public static void main(String[] args)  {
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(-2000, 50))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть < 0");

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(2000, -50))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в интервале от 0 до 100%");

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(2000, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в интервале от 0 до 100%");

        assertThat(Calculator.calculatingDiscount(2000, 50)).isEqualTo(1000);
        assertThat(Calculator.calculatingDiscount(2000, 100)).isEqualTo(0);
        assertThat(Calculator.calculatingDiscount(2000, 0)).isEqualTo(2000);
    }
}
