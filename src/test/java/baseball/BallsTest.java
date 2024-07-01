package baseball;

import baseball.domain.Ball;
import baseball.domain.BallStatus;
import baseball.domain.Balls;
import baseball.domain.PlayResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallsTest {
    private Balls answers;

    @BeforeEach
    void setUp() {
        answers = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("야구_개수_3_검증")
    void 야구_개수_3_검증(){
        assertThatThrownBy(() -> answers.play(Arrays.asList(1, 2, 3, 4))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> answers.play(Arrays.asList(1, 2))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("야구_숫자_중복_검증")
    void 야구_숫자_중복_검증(){
        assertThatThrownBy(() -> answers.play(Arrays.asList(1, 2, 2))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void play() {
        PlayResult result = answers.play(Arrays.asList(4, 5, 6));
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball() {
        PlayResult result = answers.play(Arrays.asList(1, 4, 2));
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(1);
    }

    @Test
    void play_3strike() {
        PlayResult result = answers.play(Arrays.asList(1, 2, 3));
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.isGameEnd()).isTrue();
    }

    @Test
    void strike() {
        BallStatus status = answers.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        BallStatus status = answers.play(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        BallStatus status = answers.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
