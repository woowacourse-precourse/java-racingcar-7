package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.racing.Car;
import racingcar.racing.Computer;
import racingcar.util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RacingTest {
    private Computer computer;
    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        car1 = new Car("car1");
        car2 = new Car("car2");
        car3 = new Car("car3");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        int attemptTimes = 5; // 적절한 시도 횟수 값 설정
        computer.prepareGame(cars, attemptTimes);
    }

    @DisplayName("Car 객체가 1회 움직이면 위치는 1이어야 한다.")
    @Test
    void moveSuccessTest() {
        // given : 한 개의 Car 객체 생성
        Car car = new Car("car1");

        // when : car 의 position 을 증가시킴
        car.movePosition();

        // then : car 의 position 이 1인지 확인
        assertEquals(1, car.getPosition(), "자동차가 1회 움직였으므로 위치는 1이어야 한다.");
    }

    @DisplayName("Car 객체 생성 시 초기 위치는 0이어야 한다.")
    @Test
    void initialPositionTest() {
        // given : 한 개의 Car 객체를 생성
        Car car = new Car("car");

        // then : car 의 position 이 0인지 확인
        assertEquals(0, car.getPosition(), "자동차가 움직이지 않았으므로 위치는 0이어야 한다.");
    }

    @DisplayName("우승자가 1명이면 우승자 목록에도 1명만 있다.")
    @Test
    void singleWinnerTest() {
        // given : car1 의 위치를 증가시킴
        car1.movePosition();

        // when : 우승자를 찾음
        List<Car> winners = computer.determineWinners();

        // then : 우승자는 car1 이어야 함
        assertEquals(1, winners.size(), "우승자는 1명이어야 한다.");
        assertEquals(car1, winners.getFirst(), "우승자는 car1 이어야 한다.");
    }

    @DisplayName("우승자가 2명이면 우승자 목록에도 2명이 있다.")
    @Test
    void multipleWinnersTest() {
        // given : car1, car2 의 위치를 같게 설정
        car1.movePosition();
        car2.movePosition();

        // when : 우승자를 찾음
        List<Car> winners = computer.determineWinners();

        // then : 우승자는 2명이어야 함
        assertEquals(2, winners.size(), "우승자는 2명이어야 한다.");
        assertTrue(winners.contains(car1), "우승자 목록에 car1 이 포함되어야 한다.");
        assertTrue(winners.contains(car2), "우승자 목록에 car2 가 포함되어야 한다.");
    }

    @DisplayName("자동차 목록이 비어있을 때 예외 발생")
    @Test
    void findWinnersAmongEmptyCarListTest() {
        // given : 기본 생성자로 Computer 객체를 생성 (자동차 목록이 빈 상태)
        Computer emptyComputer = new Computer();

        // then : IllegalArgumentException 발생 여부 확인
        Exception exception = assertThrows(IllegalArgumentException.class, emptyComputer::determineWinners);

        assertEquals(ErrorMessage.CAR_LIST_EMPTY_ERROR_MESSAGE.getMessage(), exception.getMessage());
    }
}
