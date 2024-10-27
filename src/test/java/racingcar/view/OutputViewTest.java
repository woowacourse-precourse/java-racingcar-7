package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    public void 경주할_자동차_이름_입력_메시지_출력() {
        // given
        int promptNumber = 1;
        OutputView outputView = new OutputView();

        // when
        outputView.displayPrompt(promptNumber);

        // then
        assertThat(output.toString()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    public void 시도할_횟수_입력_메시지_출력() {
        // given
        int promptNumber = 2;
        OutputView outputView = new OutputView();

        // when
        outputView.displayPrompt(promptNumber);

        // then
        assertThat(output.toString()).contains("시도할 횟수는 몇 회인가요?");
    }

    @Test
    public void 실행_결과_출력() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        car1.move();
        car1.move();
        car2.move();

        List<Car> cars = Arrays.asList(car1, car2, car3);
        OutputView outputView = new OutputView();

        // when
        outputView.displayRacing(cars);

        // then
        assertThat(output.toString()).contains("pobi : --", "woni : -", "jun : ");
    }

    @Test
    public void 우승자_한명_출력() {
        // given
        Car winner = new Car("pobi");
        List<Car> winners = Arrays.asList(winner);
        OutputView outputView = new OutputView();

        // when
        outputView.displayWinners(winners);

        // then
        assertThat(output.toString()).isEqualTo("최종 우승자 : pobi");
    }

    @Test
    public void 우승자_두명이상_출력() {
        // given
        Car winner1 = new Car("pobi");
        Car winner2 = new Car("woni");
        List<Car> winners = Arrays.asList(winner1, winner2);
        OutputView outputView = new OutputView();

        // when
        outputView.displayWinners(winners);

        // then
        assertThat(output.toString()).isEqualTo("최종 우승자 : pobi, woni");
    }
}
