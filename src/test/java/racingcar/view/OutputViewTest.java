package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingCar;

import java.util.Arrays;

class OutputViewTest {
    private Car car1;
    private Car car2;
    private Car car3;

    private RacingCar racingCars;
    OutputView outputView = new OutputView();

    @BeforeEach
    void setup() {
        car1 = new Car("car1");
        car2 = new Car("car2");
        car3 = new Car("car3");

        racingCars = new RacingCar(Arrays.asList(car1, car2, car3));
    }

    @DisplayName("자동차 경주 차수별 실행 결과 출력")
    @Test
    void printRacing() {
        for (int i = 0; i < 3; i++) {
            racingCars.moving();
            outputView.printRacing(racingCars.getCars());
        }
    }

    @DisplayName("단독 우승자 출력")
    @Test
    void printWinner_single() {
        car1.move(4);
        car1.move(5);
        car2.move(3);

        outputView.printWinner(racingCars.getWinner());
    }

    @DisplayName("공동 우승자 출력")
    @Test
    void printWinner_multiple() {

        car1.move(4);
        car1.move(5);
        car2.move(5);
        car2.move(5);
        car3.move(3);

        outputView.printWinner(racingCars.getWinner());
    }

    @DisplayName("최종 통합 출력 테스트")
    @Test
    void printRacing_and_printWinner() {
        for (int i = 0; i < 5; i++) {
            racingCars.moving();
            outputView.printRacing(racingCars.getCars());
        }

        outputView.printWinner(racingCars.getWinner());
    }
}