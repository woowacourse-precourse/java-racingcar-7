package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.validator.car.name.count.CarNameCountValidatorImpl;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameCountValidatorImplTest {

    private final CarNameCountValidatorImpl validator = new CarNameCountValidatorImpl();

    @Test
    public void validate_ShouldThrowException_WhenCarCountIsLessThanTwo() {
        String[] carNames = {"Car1"};

        assertThatThrownBy(() -> validator.validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 자동차의 개수가 2개 이상이여야 합니다.");
    }

    @Test
    public void validate_ShouldNotThrowException_WhenCarCountIsTwoOrMore() {
        String[] carNames = {"Car1", "Car2"};

        validator.validate(carNames); // 예외가 발생하지 않으면 테스트 통과
    }
}

