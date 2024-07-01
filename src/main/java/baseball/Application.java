package baseball;

import baseball.domain.NumberGenerator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> randomNumbers = NumberGenerator.createRandomNumbers();
    }
}
