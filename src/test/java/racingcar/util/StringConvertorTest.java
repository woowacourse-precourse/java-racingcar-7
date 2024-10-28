package racingcar.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

public class StringConvertorTest {
    @DisplayName("문자열을 숫자로 변환")
    @Test
    void toIntTest() {
        assertEquals(3, StringConvertor.toInt("3"));
        assertEquals(1412, StringConvertor.toInt("1412"));
    }

    @DisplayName("문자열을 숫자로 변환 실패 테스트")
    @Test
    void toIntExceptionTest() {
        assertThrows(NumberFormatException.class, () -> StringConvertor.toInt("a"));
    }


    @DisplayName("쉼표로 구분된 문자열을 자동차 리스트로 변환")
    @Test
    void convertStringToList_success() {
        String test1 = "pobi,jun,kim";
        List<RacingCar> list = StringConvertor.toCarList(test1);

        assertThat(list).isInstanceOf(List.class);
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isInstanceOf(RacingCar.class);
        assertThat(list.get(0).getCarName()).isEqualTo("pobi");
    }
}
