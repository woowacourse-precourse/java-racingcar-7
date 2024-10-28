package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputHandlerTest {
    private static final List<Car> cars = new ArrayList<>();
    private static final int CARS_COUNT = 10;
    private static final int TOTAL_RACE_ROUND = 100;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static PrintStream standardOut;
    private static OutputStream captor;

    @BeforeEach
    void setUpCars() {
        for (int i = 1; i <= CARS_COUNT; i++) {
            cars.add(new Car("car" + i));
        }
    }

    @BeforeEach
    protected final void initOutput() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(captor.toString());
    }

    @Test
    void 차수별실행결과출력_테스트() {
        // given
        for (int carIndex = 0; carIndex < CARS_COUNT; carIndex++) {
            Car car = cars.get(carIndex);
            for (int j = 0; j < TOTAL_RACE_ROUND; j++) {
                car.move();
            }
        }

        // when
        OutputHandler.printRoundResult(cars);
        String output = captor.toString();

        // then
        for (int carIndex = 0; carIndex < CARS_COUNT; carIndex++) {
            Car car = cars.get(carIndex);
            assertThat(output).contains(car.getName());
            assertThat(output).contains(" : " + "-".repeat(car.getMoveDistance()));
        }
    }

    @Test
    void 최종우승자출력_테스트_1명() {
        // given
        Car winnerCar = cars.get(0);
        for (int round = 0; round < TOTAL_RACE_ROUND; round++) {
            winnerCar.move();
        }

        // when
        OutputHandler.printFinalResult(cars);
        String output = captor.toString();

        // then
        assertThat(output).isEqualTo("최종 우승자 : car1\n");
    }
}