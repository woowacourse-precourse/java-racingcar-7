package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarMoverTest {
    Car car;
    CarMover carMover;

    @BeforeEach
    void setUp() {
        car = new Car("test");
        carMover = new CarMover();
    }

    /*
     * Todo: CarMover의 RandomNumberGenerator를 Mocking 하여 테스트 코드 작성하기
     *
     * 현재는 Mocking 불가능 한 상태
     * 우선 요구사항 구현에 집중하자
     */
    @Test
    void run() {
        carMover.run(car);
    }
}