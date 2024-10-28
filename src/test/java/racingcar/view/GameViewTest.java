package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static racingcar.view.ViewConstants.*;

class GameViewTest {
    private GameView gameView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        gameView = new GameView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @DisplayName("라운드별로 자동차의 이동 거리에 따라 \"-\"를 생성해 출력하기")
    @Test
    void 라운드_결과_출력_테스트() {
        Car car1 = new Car("pobi", 2);
        Car car2 = new Car("woni", 3);
        Car car3 = new Car("jun", 1);
        List<Car> cars = List.of(car1, car2, car3);

        gameView.displayRoundResult(cars);

        String expectedOutput =
                "pobi : --\n" +
                "woni : ---\n" +
                "jun : -\n\n";
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }

    @DisplayName("단독 우승자일 경우 하나의 자동차만 출력하기")
    @Test
    void 단독_우승자_출력_테스트() {
        Car car1 = new Car("pobi", WINNER_POSITION.getValue());
        List<Car> winnerCars = List.of(car1);

        gameView.displayWinners(winnerCars);

        String expectedOutput = "최종 우승자 : pobi\n";
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }

    @DisplayName("공동 우승자일 경우 쉼표(,)를 이용해 우승자 자동차만 출력하기")
    @Test
    void 공동_우승자_출력_테스트() {
        Car car1 = new Car("pobi", WINNER_POSITION.getValue());
        Car car2 = new Car("woni", WINNER_POSITION.getValue());
        List<Car> winnerCars = List.of(car1, car2);

        gameView.displayWinners(winnerCars);

        String expectedOutput = "최종 우승자 : pobi, woni\n";
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }
}
