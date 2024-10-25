package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ValidateCarTest extends NsTest {
    @Test
    void 예외_테스트_쉼표뒤에이름안들어옴() {
        assertThatThrownBy(() -> ValidateCar.validateInputCar("pobi,,java"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_쉼표만() {
        assertThatThrownBy(() -> ValidateCar.validateInputCar(",,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_빈문자열() {
        assertThatThrownBy(() -> ValidateCar.validateInputCar(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_이름길이초과() {
        assertThatThrownBy(() -> ValidateCar.validateInputCar("pobi,javaji"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_쉼표로끝날경우() {
        assertThatThrownBy(() -> ValidateCar.validateInputCar("pobi,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}