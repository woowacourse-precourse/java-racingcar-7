package racingcar.RacingCarTest;


import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.view.InstructionView;


public class BaseFunctionTest {


    @Test
    void 지시사항_출력_체크_테스트() {

        //given
        InstructionView view = new InstructionView();
        String expectedMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

        //when
        String message = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

        //then
        Assertions.assertEquals(expectedMessage, view.printInstruction(message));
    }
}
