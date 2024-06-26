package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class Balls {
    private final List<Ball> answers;

    public Balls(List<Integer> answers) {
        this.answers = mapBall(answers);;
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
