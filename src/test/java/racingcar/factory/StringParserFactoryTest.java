package racingcar.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[유닛 테스트] - 입력 값 변환")
class StringParserFactoryTest {

    private final StringParserFactory stringParserFactory = new StringParserFactory();

    @Test
    @DisplayName("자동차 이름 변환 - 적절한 형식의 자동차 이름 전달 시 자동차 이름 목록 반환")
    void properFormatCarName_parse_returnCarNameList() {
        //given
        String inputCarName = "pobi,woni,jun";

        //when
        List<String> carNameList = stringParserFactory.parseCarName(inputCarName);

        //then
        assertThat(carNameList)
                .hasSize(3)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("시도할 횟수 변환 - 적절한 형식의 시도할 횟수 전달 시 정수형 횟수 반환")
    void properFormatLoopCount_parse_returnIntegerLoopCount() {
        //given
        String inputLoopCount = "3";

        //when
        int loopCount = stringParserFactory.parseLoopCount(inputLoopCount);

        //then
        assertThat(loopCount).isEqualTo(3);
    }
}