package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Balls {
    private final List<Ball> answers;
    public static final int BALL_COUNT = 3;

    public Balls(List<Integer> answers) {
        validBalls(answers);
        this.answers = mapBall(answers);
    }

    private static void validBalls(List<Integer> answers) {
        if (answers.size() != BALL_COUNT) {
            throw new IllegalArgumentException("볼 개수는 3개이어야 합니다.");
        }
        if (answers.size() != answers.stream().distinct().count()) {
            throw new IllegalArgumentException("볼 숫자는 중복이 없어야 합니다.");
        }
    }

    private static List<Ball> mapBall(List<Integer> answers) {
        return answers.stream()
                .map(answer -> new Ball(answers.indexOf(answer) + 1, answer))
                .collect(Collectors.toList());
    }

    public BallStatus play(Ball userBall) {
        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        PlayResult result = new PlayResult();
        answers.stream()
                .map(userBalls::play)
                .forEach(result::report);
        return result;
    }
}
