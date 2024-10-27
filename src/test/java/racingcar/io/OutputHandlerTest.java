package racingcar.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.data.GameData;
import racingcar.dto.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

class OutputHandlerTest {
    private final OutputHandler outputHandler = new OutputHandler();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUpOutputStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    protected String getOutputStream() {
        return outputStream.toString().trim();
    }

    @DisplayName("실행결과를 출력한다.")
    @Test
    void test1() {
        assertSimpleTest(() -> {
            // given
            Car car1 = new Car("pobi", 1);
            Car car2 = new Car("woni", 3);
            Car car3 = new Car("john", 2);
            List<Car> carList = List.of(car1, car2, car3);

            GameData gameData = new GameData();
            gameData.save(carList);

            String rankString = "실행 결과\npobi : -\nwoni : ---\njohn : --";

            // when
            outputHandler.printCarsRacingResult(gameData);

            // then
            Assertions.assertThat(getOutputStream()).isEqualTo(rankString);
        });
    }

    @DisplayName("최종 우승자를 출력한다.")
    @Test
    void test2() {
        assertSimpleTest(() -> {
            // given
            Car car1 = new Car("pobi");
            Car car2 = new Car("woni");
            List<Car> carList = List.of(car1, car2);

            String winnerString = "최종 우승자 : pobi, woni";

            // when
            outputHandler.printWinner(carList);

            // then
            Assertions.assertThat(getOutputStream()).isEqualTo(winnerString);
        });
    }

}