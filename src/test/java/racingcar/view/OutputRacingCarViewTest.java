package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class OutputRacingCarViewTest {
    private final OutputRacingCarView outputRacingCarView;

    public OutputRacingCarViewTest() {
        this.outputRacingCarView = new OutputRacingCarView();
    }

    private ByteArrayOutputStream output() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        return output;
    }

    @AfterEach
    public void initInputAndOutput() {
        System.setOut(System.out);
    }

    @Test
    public void 경주게임_실행_결과_문자열_테스트() {
        assertSimpleTest(() -> {
            // given
            String gameResultString = "실행 결과";
            ByteArrayOutputStream output = output();

            // when
            this.outputRacingCarView.outputGameResult("");

            // then
            assertThat(output.toString())
                    .contains(gameResultString);
        });
    }

    @Test
    public void 경주게임_실행_결과_테스트() {
        assertSimpleTest(() -> {
            // given
            String gameResult = "창의 : --";
            ByteArrayOutputStream output = output();

            // when
            this.outputRacingCarView.outputGameResult(gameResult);

            // then
            assertThat(output.toString())
                    .contains(gameResult);
        });
    }

    @Test
    public void 경주게임_우승자_문자열_테스트() {
        assertSimpleTest(() -> {
            // given
            String winnersString = "최종 우승자 : ";
            ByteArrayOutputStream output = output();

            // when
            this.outputRacingCarView.outputGameWinners("");

            // then
            assertThat(output.toString())
                    .contains(winnersString);
        });
    }

    @Test
    public void 경주게임_우승자_테스트() {
        assertSimpleTest(() -> {
            // given
            String winnerNames = "창의, 민규, 지후";
            ByteArrayOutputStream output = output();

            // when
            this.outputRacingCarView.outputGameWinners(winnerNames);

            // then
            assertThat(output.toString())
                    .contains(winnerNames);
        });
    }

}
