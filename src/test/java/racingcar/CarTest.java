package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.util.validator.PlayerNameValidator;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {

    private PlayerNameValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PlayerNameValidator();
    }
    @DisplayName("자동차 객체 생성 성공 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"한동근", "두동근", "3동근", "four", "12345"})
    void carNameSuccessTest(String name) {
        Car car = new Car(name);

        Assertions.assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 객체 생성 실패 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "     ", "123456", "한동근두동근세동근네동근"})
    void carNameFailTest(String name) {
        assertThatThrownBy(() -> validator.validateName(List.of(name)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
