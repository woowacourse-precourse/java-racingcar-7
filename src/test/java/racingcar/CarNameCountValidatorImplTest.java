package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.car.name.count.CarNameCountValidatorImpl;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameCountValidatorImplTest {

    private final CarNameCountValidatorImpl validator = new CarNameCountValidatorImpl();

    @DisplayName("입력한 자동차 개수가 1미만일 떄 IllegalArgumentException 이 발생하는지 Test")
    @Test
    public void validate_ShouldThrowException_WhenCarCountIsLessThanTwo() {
        String[] carNames = {"Car1"};

        assertThatThrownBy(() -> validator.validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 자동차의 개수가 2개 이상이여야 합니다.");
    }

    @DisplayName("입력한 자동차 이름 문자열이 정상적으로 유효성 검사를 통과하는지 Test")
    @Test
    public void validate_ShouldNotThrowException_WhenCarCountIsTwoOrMore() {
        String[] carNames = {"Car1", "Car2"};

        Assertions.assertDoesNotThrow(() -> validator.validate(carNames)); // 예외가 발생하지 않으면 테스트 통과
    }
}

