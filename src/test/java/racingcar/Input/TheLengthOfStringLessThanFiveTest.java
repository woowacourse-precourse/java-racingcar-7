package racingcar.Input;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.service.InputService.isTheLengthOfStringLessThanFive;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.service.InputService;

public class TheLengthOfStringLessThanFiveTest extends NsTest {

    @Test
    public void 이름_길이가_5자_이하이다1() {
        // given
        String input = "pobi,woni,jun";

        // when
        boolean result = isTheLengthOfStringLessThanFive(input);

        // then
        assertTrue(result);
    }

    @Test
    public void 이름_길이가_5자_이하이다2() {
        // given
        String input = "pobi4,woni1,jun6";

        // when
        boolean result = isTheLengthOfStringLessThanFive(input);

        // then
        assertTrue(result);
    }

    @Test
    public void 이름_길이가_5자_초과이다() {
        // given
        String input = "pobi123,woni1,jun6";

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> InputService.isTheLengthOfStringLessThanFive(input));
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}