package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.utils.StringConvertor;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringConvertorTest {

    @DisplayName("문자열을 숫자로 변환")
    @Test
    void convertStringToInt_success() {
        assertThat(3).isEqualTo(StringConvertor.toInt("3"));
        assertThat(12).isEqualTo(StringConvertor.toInt("12"));
    }

    @DisplayName("문자열을 숫자로 변환해주는 실패 테스트")
    @Test
    void convertStringToInt_throwsException() {
        assertThrows(NumberFormatException.class, () -> StringConvertor.toInt("a"));
    }

    @DisplayName("쉼표로 구분된 문자열을 자동차 리스트로 변환")
    @Test
    void convertStringToList_success() {
        String test1 = "pobi,jun,kim";
        List<Car> list = StringConvertor.toCarList(test1);

        assertThat(list).isInstanceOf(List.class);
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isInstanceOf(Car.class);
        assertThat(list.get(0).getName()).isEqualTo("pobi");
    }

}