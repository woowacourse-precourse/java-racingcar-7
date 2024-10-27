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
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUpOutputStreams() {
        System.setOut(new PrintStream(outputStream));
    }

//    @AfterEach
//    void restoreOutputStreams() {
//        System.setOut(standardOut);
//        outputStream.reset();
//    }

    protected String getOutputStream() {
        return outputStream.toString().trim();
    }

    @DisplayName("실행결과를 출력한다.")
    @Test
    void test1() {
        assertSimpleTest(() -> {
            // given
            List<Car> carList = createCarList();

            GameData gameData = new GameData();
            gameData.save(carList);

            String rankString = "실행 결과\npobi : -\nwoni : ---\njohn : --";

            // when
            outputHandler.printCarsRacingResult(gameData);

            // then
            Assertions.assertThat(getOutputStream()).isEqualTo(rankString);
        });
    }

    private List<Car> createCarList() {
        Car car1 = new Car("pobi", 1);
        Car car2 = new Car("woni", 3);
        Car car3 = new Car("john", 2);
        return List.of(car1, car2, car3);
    }

}