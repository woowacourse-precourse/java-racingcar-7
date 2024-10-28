package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Movement;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparatorTest {
    /** 테스트 클래스 명 -> [메서드 명]_[테스트 중 상태]_[기대 행위] **/
    @Test
    @DisplayName("쉼표(,)를 기준으로 문자열이 분리되는지 테스트")
    void split_InputtedString_gotStringArray() {
        //given
        String carNames = "Ahn,Seong,Mo";
        String[] expectedResult = {"Ahn","Seong","Mo"};

        //when
        String[] carNamesArray = Separator.split(carNames);

        //then
        assertThat(carNamesArray).isEqualTo(expectedResult);
    }
}
