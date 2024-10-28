package racingcar.util;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.util.Delimiter.COMMA;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UtilityTest {

    @Test
    @DisplayName("구분자(쉼표)를 기준으로 이름을 입력했을 때 정상 추출되는지 확인")
    void 이름_추출_테스트() {
        //given
        String inputCarNames = "12345,qwer,ㄱㄴㄷ";

        //when
        List<String> splitCarNames = Utility.getSplitCarNames(inputCarNames);

        //then
        assertThat(splitCarNames).isEqualTo(List.of("12345", "qwer", "ㄱㄴㄷ"));
    }

    @ParameterizedTest
    @CsvSource({
            "'a , b, c ', 'a,b,c'",
            "' a , b,c', 'a,b,c'",
            "'a,b,c', 'a,b,c'"
    })
    @DisplayName("이름 앞, 뒤에 공백이 있는 경우")
    void 이름_앞뒤_공백_테스트(String inputCarNames, String expectedCarNames) {
        //given & when
        List<String> carNamesList = Utility.getSplitCarNames(inputCarNames);

        //then
        assertThat(carNamesList).isEqualTo(List.of(expectedCarNames.split(COMMA.getDelimiter())));
    }
}