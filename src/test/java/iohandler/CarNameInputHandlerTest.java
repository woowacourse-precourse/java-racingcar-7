package iohandler;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameInputHandlerTest {

    private CarNameInputHandler carNameInputHandler = new CarNameInputHandler();

    @Test
    void 입력한_차_이름을_쉼표로_구분하여_리스트로_변환하기() {
        // given
        String inputCarName = "pobi,woni,jun";

        // when
        List<String> separatedCarNameList = carNameInputHandler.getSeparatedCarNameList(inputCarName);

        // then
        assertThat(separatedCarNameList).hasSize(3)
                .isEqualTo(List.of("pobi", "woni", "jun"));
    }

    @Test
    void 입력한_차_이름_5자_이하가_아니면_에러_던지기() {
        // given
        String inputCarName = "pobi,woni,juniara";

        // when // then
        assertThatThrownBy(() -> carNameInputHandler.getSeparatedCarNameList(inputCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

}