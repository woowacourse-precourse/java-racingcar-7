package racingcar.view.console;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.Arrays;
import racingcar.domain.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleOutputViewTest extends NsTest {

    @Test
    void 자동차_이름_요청_메시지를_출력한다() {
        run();

        ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        consoleOutputView.printCarNamesRequest();

        assertThat(output()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 시도_횟수_요청_메시지를_출력한다() {
        run();

        ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        consoleOutputView.printTryCountRequest();

        assertThat(output()).isEqualTo("시도할 횟수는 몇 회인가요?");
    }

    @Test
    void 경주_상태를_출력한다() {
        run();

        ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        Car car1 = new Car("amy");
        Car car2 = new Car("dan");
        car1.move(new RandomNumberGenerator());
        car2.move(new RandomNumberGenerator());

        consoleOutputView.printRoundResult(Arrays.asList(car1, car2));

        assertThat(output()).contains("amy :");
        assertThat(output()).contains("dan :");
    }

    @Test
    void 우승자를_출력한다() {
        run();

        ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        Car car1 = new Car("우아한");
        Car car2 = new Car("테크코스");

        consoleOutputView.printWinners(List.of(car1, car2));

        assertThat(output()).isEqualTo("최종 우승자 : 우아한, 테크코스");
    }

    @Override
    protected void runMain() {
    }
}