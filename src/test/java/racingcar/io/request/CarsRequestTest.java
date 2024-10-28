package racingcar.io.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsRequestTest {

    @DisplayName("자동차의 이름은 NULL 일 수 없다.")
    @Test
    void carsRequestIsNotNull() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new CarsRequest(null))
            .withMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @DisplayName("자동차의 이름은 빈 값일 수 없다.")
    @Test
    void carsRequestIsNotEmpty() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new CarsRequest(""))
            .withMessage("자동차 이름은 공백일 수 없습니다.");
    }


    @DisplayName("자동차의 이름은 공백 일 수 없다.")
    @Test
    void carsRequestIsNotBlank() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new CarsRequest("        "))
            .withMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @DisplayName("자동차 이름 사이에 공백이 존재할 수 없다.")
    @Test
    void cannotUseSpaceBetweenCarName() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new CarsRequest("po  bi"))
            .withMessage("자동차 이름과 쉼표만 입력해주세요. 공백은 사용 할 수 없습니다.");
    }

    @DisplayName("입력에 공백이 존재 할 수 없다.")
    @Test
    void cannotUseSpaceToInput() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new CarsRequest("pobi, crong"))
            .withMessage("자동차 이름과 쉼표만 입력해주세요. 공백은 사용 할 수 없습니다.");
    }

    @DisplayName("입력에 특수문자가 존재 할 수 없다.")
    @Test
    void cannotUseSpecialCharacterInCarName() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new CarsRequest("pobi!,cho"))
            .withMessage("자동차 이름과 쉼표만 입력해주세요. 공백은 사용 할 수 없습니다.");
    }

    @DisplayName("자동차 이름을 쉼표로 구분하여 입력받는다.")
    @ParameterizedTest
    @CsvSource(value = {"'pobi,crong'", "'pobi,crong,honux'", "'민혁,포비'", "'1호차,2호차,3호차'"})
    void carRequest(String input) {
        //given
        CarsRequest carsRequest = new CarsRequest(input);
        //when
        //then
        assertThat(carsRequest)
            .extracting("nameOfCars")
            .isEqualTo(input);
    }

}