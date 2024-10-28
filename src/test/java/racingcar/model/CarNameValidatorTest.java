package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    private CarNameValidator carNameValidator;

    @BeforeEach
    void setUp() {
        this.carNameValidator = new CarNameValidator();
    }

    @Test
    void 정상_입력() {
        // given
        List<String> carNames = List.of("BMW", "Audi", "Kia");

        // when & then
        assertThatNoException().isThrownBy(() -> carNameValidator.validateCarNameList(carNames));
    }

    @Test
    void 자동차_이름_5자_초과() {
        //given
        List<String> carNames = List.of("carcarcar1", "carcarcar2");

        // when & then
        assertThatThrownBy(() -> carNameValidator.validateCarNameList(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_이름_공백_1() {
        // given
        List<String> carNames = List.of("  ", "car2");

        // when & then
        assertThatThrownBy(() -> carNameValidator.validateCarNameList(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름이 공백일 수 없습니다.");
    }

    @Test
    void 자동차_이름_공백_2() {
        // given
        List<String> carNames = List.of("", "car2");

        // when & then
        assertThatThrownBy(() -> carNameValidator.validateCarNameList(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름이 공백일 수 없습니다.");
    }

    @Test
    void 자동차_이름_특수문자_포함() {
        // given
        List<String> carNames = List.of("car#1", "car2$");

        // when & then
        assertThatThrownBy(() -> carNameValidator.validateCarNameList(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 제어문자 및 메타문자를 포함할 수 없습니다.");
    }

    @Test
    void 자동차_리스트_비어있는_경우_1() {
        // given
        List<String> carNames = List.of();

        // when & then
        assertThatThrownBy(() -> carNameValidator.validateCarNameList(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 한 대 이상의 자동차가 필요합니다.");
    }

    @Test
    void 자동차_리스트_비어있는_경우_2() {
        // given
        List<String> carNames = List.of(" ");

        // when & then
        assertThatThrownBy(() -> carNameValidator.validateCarNameList(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 한 대 이상의 자동차가 필요합니다.");
    }

    @Test
    void 자동차_리스트_비어있는_경우_3() {
        // given
        List<String> carNames = List.of("");

        // when & then
        assertThatThrownBy(() -> carNameValidator.validateCarNameList(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 한 대 이상의 자동차가 필요합니다.");
    }

    @Test
    void 자동차_이름_중복_테스트() {
        // given
        List<String> carNames = List.of("car", "car");

        // when & then
        assertThatThrownBy(() -> carNameValidator.validateCarNameList(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 서로 중복될 수 없습니다.");
    }
}