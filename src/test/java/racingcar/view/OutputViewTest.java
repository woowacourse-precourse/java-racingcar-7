package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

class OutputViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("경주할 자동차 이름을 입력받는 안내 메시지를 출력한다")
    void printCarNamesInputGuide() {
        OutputView.printCarNamePrompt();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("시도할 횟수를 입력받는 안내 메시지를 출력한다")
    void printTryCountInputGuide() {
        OutputView.printTryCountPrompt();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo("시도할 횟수는 몇 회인가요?");
    }

    @Test
    @DisplayName("라운드 결과를 출력한다")
    void printRoundResult() {
        List<Car> cars = List.of(new Car("car1"), new Car("car2"));
        for (int i = 0; i < 3; i++) {
            cars.get(0).move(4);
        }
        cars.get(1).move(3);

        OutputView.printRoundResults(cars);
        String expectedOutput = "car1 : ---" + System.lineSeparator() + "car2 :";
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("최종 우승자를 출력한다")
    void printWinners() {
        //given
        List<Car> cars = List.of(new Car("car1"), new Car("car2"), new Car("car3"));
        RacingGame racingGame = new RacingGame(cars, 5);

        //when
        cars.get(0).move(4);
        cars.get(1).move(4);
        cars.get(2).move(3);
        List<Car> winners = racingGame.getWinners();

        OutputView.printWinners(winners);
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : car1, car2");
    }
}
