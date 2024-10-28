package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.utils.Constant.COLON;
import static racingcar.utils.Constant.MOVING;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


class CarTest {

    @Test
    @DisplayName("출력 결과 확인 테스트")
    void carTest1() {
        // given
        CarName carName = CarName.create("car");

        Car car = Car.create(carName, 5);

        // when
        String result = car.status();

        // then
        assertThat(result).isEqualTo(carName + COLON + "-----");
    }

    @Test
    @DisplayName("최소 값 테스트")
    void carTest2() {
        // given
        CarName carName = CarName.create("car");

        Car car = Car.create(carName, 0);

        // when
        String result = car.status();

        // then
        assertThat(result).isEqualTo(carName + COLON);
    }

    @Test
    @DisplayName("최소 값 테스트")
    void carTest3() {
        // given
        CarName carName = CarName.create("car");

        Car car = Car.create(carName);

        // when
        String result = car.status();

        // then
        assertThat(result).isEqualTo(carName + COLON);
    }

    @Disabled
    @Test
    @DisplayName("최대 값 테스트 : 최대 반복 횟수 확인")
    void carTestMaxCount() {
        CarName carName = CarName.create("1234");

        // 테스트 결과 1410000000 정도에서 메모리 초과
        int tryCount = 1410000000;
        int increase = 10000000;
        boolean memoryExceeded = false;

        while (!memoryExceeded) {
            try {
                Car car = Car.create(carName, tryCount);
                String result = car.status();
                assertThat(result).isEqualTo(carName + COLON + MOVING.repeat(tryCount));
                tryCount += increase;
            } catch (OutOfMemoryError e) {
                memoryExceeded = true;
                System.out.println("Memory exceeded at tryCount: " + tryCount);
            }
        }
    }

    @ParameterizedTest
    @DisplayName("유효하지 않은 입력값 테스트")
    @ValueSource(strings = {"자동차이름긺"})
    @NullAndEmptySource
    void test4(String carName) {

        assertThrows(IllegalArgumentException.class, () ->
                CarName.create(carName)
        );
    }

    @Test
    @DisplayName("이름 5자 테스트")
    void test5() {
        CarName carName = CarName.create("12345");
        Car car = Car.create(carName);
        assertThat(car.status()).isEqualTo(carName + COLON + MOVING.repeat(0));
    }


}
