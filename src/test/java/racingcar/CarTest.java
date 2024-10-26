package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    List<Car> cars = new ArrayList<>();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        cars.add(new Car("test3"));
    }


    @Test
    @DisplayName("RacingCount 필드 가져오는 테스트")
    void getRacingCount() {
        for (Car car : cars) {
            car.drive(true);
            assertThat(car.getRacingCount()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("CarName 필드 가져오는 테스트")
    void getCarName() {
        int index = 1;
        for (Car car : cars) {
            assertThat(car.getCarName()).isEqualTo("test" + index);
            index++;
        }
    }

    @Test
    @DisplayName("Drive method test: 랜덤한 값이 4 이상일 때, 각 차량의 필드 racingCount는 1씩 증가한다. ")
    void drive() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.drive(randomNumber >= 4);
        }
        for (Car car : cars) {
            assertThat(car.getRacingCount())
                    .isGreaterThan(-1)
                    .isLessThan(2);
        }
    }

    @Test
    @DisplayName("showRacingCarCompetition method test: car의 필드인 RacingCount 만큼 [-] 출력 테스트")
    void showRacingCarCompetition() {
        System.setOut(new PrintStream(outputStream));
        StringBuilder expectedOutput = new StringBuilder();


        for (Car car : cars) {
            car.drive(true);
        }

        for (Car car : cars) {
            car.showRacingCarCompetition();
            expectedOutput.append(car.getCarName()).append(" : ")
                    .append("-".repeat(car.getRacingCount()))
                    .append("\n");
        }
        assertThat(expectedOutput.toString()).isEqualTo(outputStream.toString());
    }
}