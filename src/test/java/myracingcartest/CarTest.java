package myracingcartest;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Score;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("디스플레이네임 어노테이션 테스트")
    void 자동차_생성_테스트() {
        // 생성, 초기값
        String shortNameForTest = "name";
        Car car1 = new Car(shortNameForTest);

        // 그러면 어떤 결과를 예상하고, 어떻게 나오는지?
        assertEquals(shortNameForTest, car1.getUserName(), "자동차 이름 입력 에러");
        assertEquals(0, car1.getScore().getScore(), "스코어 초기값 에러");

        /**
         * assertThatNoException : 특정 코드 블록에서 예외가 발생하지 않음을 검증하기 위한 AssertJ의 메서드
         * isThrownBy : 이 코드가 예외가 발생하지 않는지?
         * 람다 : 생성자에서 예외가 발생하는지에 대해
         */
        assertThatNoException()
                .isThrownBy(() -> new Car(shortNameForTest));

        // 예외사항 제공
        String longNameForTest = "longname";

        // 예외를 던지는지?
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(longNameForTest);
        });
    }

    @Test
    void 자동차_스코어_테스트() {
        Car testCar = new Car("test");

        testCar.moveCar(4);
        assertEquals(1, testCar.getScore().getScore(), "moveCar 메서드 에러");

        testCar.moveCar(5);
        assertEquals(2, testCar.getScore().getScore(), "moveCar 메서드 에러");

        testCar.moveCar(1);
        assertEquals(2, testCar.getScore().getScore(), "moveCar 메서드 에러");
    }

    @Nested
    @DisplayName("자동차 스코어 테스트")
    class 클래스_안_클래스 {
        private Car car;
        private Score score;

        @BeforeEach
        void init() {
            this.car = new Car("test");
            this.score = new Score();
        }

        @ParameterizedTest
        @ValueSource(ints = {4, 5, 6, 7})
        void 자동차_점수_테스트_파라미터(int expectedRandomNumber) {
            car.moveCar(expectedRandomNumber);
            score.moveForward();

            assertThat(car.getScore().getScore()).isEqualTo(score.getScore());
        }

    }
}
