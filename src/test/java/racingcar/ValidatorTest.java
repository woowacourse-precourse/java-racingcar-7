package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.util.Validator;
import java.util.ArrayList;
import java.util.List;

class ValidatorTest {

    @Test
    @DisplayName("비어있는 입력이 들어오는 경우 True를 리턴하는지 검증")
    void validBlank() {
        // given
        Validator validator = new Validator();

        // when, then
        assertThat(validator.validBlank("", "1")).isTrue();
    }

    @Test
    @DisplayName("수가 아닌 입력이 들어온 경우 True를 리턴하는지 검증")
    void validNumber() {
        // given
        Validator validator = new Validator();

        // when, then
        assertThat(validator.validNumber("number")).isTrue();
    }

    @Test
    @DisplayName("자동차의 이름이 5보다 긴 경우 True를 리턴하는지 검증")
    void validNameLength() {
        // given
        Validator validator = new Validator();
        List<Car> carList = new ArrayList<>();

        // when
        carList.add(new Car("car1"));
        carList.add(new Car("car2"));
        carList.add(new Car("long long name"));

        // then
        assertThat(validator.validNameLength(carList)).isTrue();

    }
}