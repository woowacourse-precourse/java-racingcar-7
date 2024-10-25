package io;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarInputHandlerTest {

    private RacingCarInputHandler racingCarInputHandler = new RacingCarInputHandler();

    @Test
    void 입력한_차_이름을_쉼표로_구분하여_리스트로_변환하기() {
        // given
        String inputCarName = "pobi,woni,jun";

        // when
        List<String> separatedCarNameList = racingCarInputHandler.getSeparatedCarNameList(inputCarName);

        // then
        assertThat(separatedCarNameList).hasSize(3)
                .isEqualTo(List.of("pobi", "woni", "jun"));
    }

    @Test
    void 입력한_차_이름_5자_이하가_아니면_에러_던지기() {
        // given
        String inputCarName = "pobi,woni,juniara";

        // when // then
        assertThatThrownBy(() -> racingCarInputHandler.getSeparatedCarNameList(inputCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 입력한_차_이름_공백_시_에러_던지기() {
        // given
        String inputCarName = "pobi,,juniara";

        // when // then
        assertThatThrownBy(() -> racingCarInputHandler.getSeparatedCarNameList(inputCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요.");
    }

    @Test
    void 시도할_횟수_입력하기() {
        // given
        String inputCount = "4";

        // when
        int inputRacingCount = racingCarInputHandler.getRacingCount(inputCount);

        // then
        assertThat(inputRacingCount).isEqualTo(Integer.parseInt(inputCount));
    }

    @Test
    void 시도할_횟수_양수가_아닌_경우_에러_던지기() {
        // given
        String inputCount = "-1";

        // when // then
        assertThatThrownBy(() -> racingCarInputHandler.getRacingCount(inputCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 양수 이여야합니다.");
    }

    @Test
    void 시도할_횟수_숫자가_아닌_경우_에러_던지기() {
        // given
        String inputCount = "aa";

        // when // then
        assertThatThrownBy(() -> racingCarInputHandler.getRacingCount(inputCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 양수 이여야합니다.");
    }
}