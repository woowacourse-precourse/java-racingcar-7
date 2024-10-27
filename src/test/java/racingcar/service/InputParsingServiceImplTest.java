package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputParsingServiceImplTest {
    InputParsingServiceImpl inputParsingService;

    @BeforeEach
    void create() {
        inputParsingService = new InputParsingServiceImpl();
    }

    @Test
    void 자동차_이름_문자열_파싱_테스트() {
        //given
        String input = "pobi,woni,jun";

        //when
        List<String> carNameList = inputParsingService.parseCarNameListString(input);

        //then
        assertThat(carNameList)
                .isEqualTo(List.of("pobi", "woni", "jun"));

    }

    @Test
    void 시도_횟수_파싱_테스트() {
        //given
        String input = "5";

        //when
        int attemptCount = inputParsingService.parseAttemptCountString(input);

        //then
        assertThat(attemptCount)
                .isEqualTo(5);
    }

    @Test
    void 시도_횟수_파싱_예외_테스트() {
        //given
        String input = "aa";

        //when,then
        assertThatThrownBy(
                () -> inputParsingService.parseAttemptCountString(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
