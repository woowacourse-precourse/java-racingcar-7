package racingcar.modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Winner;

class WinnerTest {

    @Test
    void 승자_정상_추출_테스트() {
        // given
        List<Car> cars = Arrays.asList(
            new Car("Car1"),
            new Car("Car2"),
            new Car("Car3")
        );

        // 자동차의 위치 설정
        cars.get(0).move(); // Car1 위치: 1
        cars.get(1).move(); // Car2 위치: 1
        cars.get(1).move(); // Car2 위치: 2
        cars.get(2).move(); // Car3 위치: 1

        Winner winner = new Winner();

        // when
        String winners = winner.getWinners(cars);

        // then
        assertEquals("Car2", winners, "Car2가 가장 멀리 갔으므로 승자로 추출되어야 합니다.");
    }

    @Test
    void 동점_승자_추출_테스트() {
        // given
        List<Car> cars = Arrays.asList(
            new Car("Car1"),
            new Car("Car2"),
            new Car("Car3")
        );

        // 자동차의 위치 설정 (모두 동점)
        cars.get(0).move(); // Car1 위치: 1
        cars.get(1).move(); // Car2 위치: 1
        cars.get(2).move(); // Car3 위치: 1

        Winner winner = new Winner();

        // when
        String winners = winner.getWinners(cars);

        // then
        assertEquals("Car1, Car2, Car3", winners, "세 자동차가 동일한 위치에 있으므로 모두 승자로 추출되어야 합니다.");
    }

    @Test
    void 승자_한명_추출_출력_테스트() {
        // given
        List<Car> cars = Arrays.asList(
            new Car("Car1"),
            new Car("Car2"),
            new Car("Car3")
        );

        // 자동차의 위치 설정
        cars.get(0).move(); // Car1 위치: 1
        cars.get(0).move(); // Car1 위치: 2
        cars.get(1).move(); // Car2 위치: 1

        Winner winner = new Winner();

        // when
        String winners = winner.getWinners(cars);

        // then
        System.out.println("승자: " + winners);
        assertEquals("Car1", winners, "Car1이 가장 멀리 갔으므로 승자로 추출되어야 합니다.");
    }

    @Test
    void 승자_여러명_추출_출력_테스트() {
        // given
        List<Car> cars = Arrays.asList(
            new Car("Car1"),
            new Car("Car2"),
            new Car("Car3")
        );

        // 자동차의 위치 설정 (Car1과 Car3이 동점)
        cars.get(0).move(); // Car1 위치: 1
        cars.get(2).move(); // Car3 위치: 1

        Winner winner = new Winner();

        // when
        String winners = winner.getWinners(cars);

        // then
        System.out.println("승자: " + winners);
        assertEquals("Car1, Car3", winners, "Car1과 Car3이 같은 위치에 있으므로 둘 다 승자로 추출되어야 합니다.");
    }
}