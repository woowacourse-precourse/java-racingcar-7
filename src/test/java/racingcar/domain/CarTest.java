package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.utils.Constant.COLON_SEPARATOR;
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
        String name = "car";
        Car car = Car.create(name, 5);

        // when
        String result = car.status();

        // then
        assertThat(result).isEqualTo(name + COLON_SEPARATOR + "-----");
    }

    @Test
    @DisplayName("최소 값 테스트")
    void carTest2() {
        // given
        String name = "car";
        Car car = Car.create(name, 0);

        // when
        String result = car.status();

        // then
        assertThat(result).isEqualTo(name + COLON_SEPARATOR);
    }

    @Test
    @DisplayName("최소 값 테스트")
    void carTest3() {
        // given
        String name = "car";
        Car car = Car.create(name);

        // when
        String result = car.status();

        // then
        assertThat(result).isEqualTo(name + COLON_SEPARATOR);
    }

    @Disabled
    @Test
    @DisplayName("최대 값 테스트 : 최대 반복 횟수 확인")
    void carTestMaxCount() {
        String name = "c";

        // 테스트 결과 1410000000 정도에서 메모리 초과
        int tryCount = 1410000000;
        int increase = 10000000;
        boolean memoryExceeded = false;

        while (!memoryExceeded) {
            try {
                Car car = Car.create(name, tryCount);
                String result = car.status();
                assertThat(result).isEqualTo(name + COLON_SEPARATOR + MOVING.repeat(tryCount));
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
    void test4(String name) {
        assertThrows(IllegalArgumentException.class, () -> {
            Car.create(name);
        });
    }

    @Test
    @DisplayName("이름 5자 테스트")
    void test5() {
        String name = "12345";
        Car car = Car.create(name);
        assertThat(car.status()).isEqualTo(name + COLON_SEPARATOR + MOVING.repeat(0));
    }


}
