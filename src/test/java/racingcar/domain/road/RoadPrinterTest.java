package racingcar.domain.road;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.entity.Car;
import racingcar.domain.road.entity.Road;
import racingcar.domain.road.service.RoadPrinter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class RoadPrinterTest {
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("자동차 이름과 이동 거리를 올바르게 출력한다")
    void printRoadWithValidLength() {
        // given
        Car car = new Car("pobi");
        car.getRoad().addRoad(1);

        // when
        RoadPrinter.printRoad(car);

        // then
        String actual = outputStream.toString().lines().findFirst().orElse("");
        assertThat(actual).isEqualTo("pobi : -");
    }

}