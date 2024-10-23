package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차_무작위_값이_4_이상일_때_전진() {
        // Given
        Car car = new Car("pobi");

        // When
        for (int i = 0; i < 100; i++) {
            int randomValue = car.move();
            if (randomValue >= 4) {
                assertTrue(car.getPosition() >= 1); // 전진 확인
                return;
            }
        }

        fail("무작위 값이 4 이상일 때 전진하는 테스트를 확인하지 못했습니다.");
    }

    @Test
    void 자동차_무작위_값이_4_미만일_때_멈춤() {
        // Given
        Car car = new Car("woni");

        // When
        for (int i = 0; i < 100; i++) {
            int randomValue = car.move();
            if (randomValue < 4) {
                assertEquals(0, car.getPosition()); // 멈춤 확인
                return;
            }
        }

        fail("무작위 값이 4 미만일 때 멈추는 테스트를 확인하지 못했습니다.");
    }
}
