package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.Constant.COLON_SEPARATOR;
import static racingcar.utils.Constant.MOVING;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CarTest {

    @Test
    @DisplayName("출력 결과 확인 테스트")
    void carTest1() {
        // given
        String name = "car";
        Car car = new Car(name, 5);

        // when
        String result = car.generateStatus();

        // then
        assertThat(result).isEqualTo(name + COLON_SEPARATOR + "-----");
    }

    @Test
    @DisplayName("최소 값 테스트")
    void carTest2() {
        // given
        String name = "car";
        Car car = new Car(name, 0);

        // when
        String result = car.generateStatus();

        // then
        assertThat(result).isEqualTo(name + COLON_SEPARATOR);
    }

    @Test
    @DisplayName("최소 값 테스트")
    void carTest3() {
        // given
        String name = "car";
        Car car = new Car(name);

        // when
        String result = car.generateStatus();

        // then
        assertThat(result).isEqualTo(name + COLON_SEPARATOR);
    }

    @Test
    @DisplayName("최대 값 테스트 : 최대 반복 횟수 확인")
    void carTestMaxCount() {
        String name = "c";
        int tryCount = 100000000;
        int increase = 10000000;
        boolean memoryExceeded = false;

        while (!memoryExceeded) {
            try {
                Car car = new Car(name, tryCount);
                String result = car.generateStatus();
                assertThat(result).isEqualTo(name + COLON_SEPARATOR + MOVING.repeat(tryCount));
                tryCount += increase;
            } catch (OutOfMemoryError e) {
                memoryExceeded = true;
                System.out.println("Memory exceeded at tryCount: " + tryCount);
            }
        }
    }


}
