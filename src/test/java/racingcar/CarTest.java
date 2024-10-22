package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @Test
    @DisplayName("자동차는 생성자로 이름을 가지며, 이 이름은 변경 될 수 없다.")
    void construct() {
        String name = "testName";
        Car car = new Car(name);
        Assertions.assertThat(car.getName()).isEqualTo(name);
        // TODO : 이름이 "," 인 경우엔 공백 이름으로 생각해야 하는지 고민한다. 또한 공백 이름을 허용할 지 고민한다.
    }

    @ParameterizedTest
    @DisplayName("0~3이 나오면 정지, 4~9 가 나오면 이동한다.")
    @CsvSource({
            "0, 0",
            "1, 0",
            "2, 0",
            "3, 0",
            "4, 1",
            "5, 1",
            "6, 1",
            "7, 1",
            "8, 1",
            "9, 1"
    })
    void move(int input, int expectedDistance) {
        Car car = new Car("name");
        car.move(input);
        Assertions.assertThat(car.getDistance()).isEqualTo(expectedDistance);
    }

    // 랜덤은 다른곳에서 테스트한다.
}
