package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.InputParser;

public class InputParserTest {


    @DisplayName("userInput을 구분자','로 나누어 리스트로 반환한다")
    @Test
    void userInput_split_then_return_list(){
        String userInput = "aa,bb,cc,ddd";
        List<String> expectedResult = List.of("aa","bb","cc","ddd");
        List<String> splitLists = InputParser.parserCarNames(userInput);
        assertThat(splitLists.size()).isEqualTo(expectedResult.size());
        assertThat(splitLists).isEqualTo(expectedResult);
    }

}
