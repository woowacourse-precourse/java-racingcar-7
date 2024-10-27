package racingcar.domain.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarNameValidatorTest {

    private CarNameValidator carNameValidator;

    @BeforeEach
    void setUp() {
        carNameValidator = new CarNameValidator();
    }

    @Test
    void 빈_리스트_있을시_예외_발생() {
        //given
        List<String> emptyList = List.of(",".split(","));

        //when
        try {
            carNameValidator.validate(emptyList);
        } catch (IllegalArgumentException e) {
            assertThat("입력한 값은, 만 있으면 안 됩니다.").isEqualTo(e.getMessage());
        }

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carNameValidator.validate(emptyList);
        });
    }

    @Test
    void 빈_자동차_이름_있을시_예외_발생() {
        //given
        List<String> carName = List.of("hi,I'm,bo,wook,,^^".split(","));

        //when
        try {
            carNameValidator.validate(carName);
        } catch (IllegalArgumentException e) {
            assertThat("자동차 이름은 비어있거나 공백이면 안 됩니다.").isEqualTo(e.getMessage());
        }

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carNameValidator.validate(carName);
        });
    }

    @Test
    void 스페이스_자동차_이름_있을시_예외_발생() {
        //given
        List<String> carName = List.of("hi, ,^^".split(","));

        //when
        try {
            carNameValidator.validate(carName);
        } catch (IllegalArgumentException e) {
            assertThat("자동차 이름은 비어있거나 공백이면 안 됩니다.").isEqualTo(e.getMessage());
        }

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carNameValidator.validate(carName);
        });
    }

    @Test
    void 자동차_이름_5자_초과_예외_발생() {
        //given
        List<String> carName = List.of("bowook".split(","));

        //when
        try {
            carNameValidator.validate(carName);
        } catch (IllegalArgumentException e) {
            assertThat("자동차 이름의 길이는 5자를 초과하면 안 됩니다.").isEqualTo(e.getMessage());
        }

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carNameValidator.validate(carName);
        });
    }

    @Test
    void 자동차_이름_중복_예외_발생() {
        //given
        List<String> carName = List.of("bo,bo".split(","));

        //when
        try {
            carNameValidator.validate(carName);
        } catch (IllegalArgumentException e) {
            assertThat("같은 자동차의 이름을 입력하면 안 됩니다.").isEqualTo(e.getMessage());
        }

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carNameValidator.validate(carName);
        });
    }

    @Test
    void 유효한_자동차_예외_발생_안함() {
        //given
        List<String> carNames = List.of("hello,I'm,bo,wook,^^".split(","));

        //when&then
        assertDoesNotThrow(() -> carNameValidator.validate(carNames));
    }
}
