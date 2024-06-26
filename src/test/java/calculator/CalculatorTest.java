package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("문자열의 왼쪽 순서대로 계산한다.")
    void calculate(){
        Calculator calculator = new Calculator();
        String value = "2 + 3 * 4 / 2";
        int result = calculator.calculate(value);
        assertThat(result).isEqualTo(10);
    }
}
