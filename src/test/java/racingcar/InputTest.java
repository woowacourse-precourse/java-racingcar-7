package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputTest {
    @Test
    public void 정확한_입력_테스트(){
        String validInput = "pobi,woni,jun";
        List<String> names = Input.splitName(validInput);
        assertEquals(3, names.size());
        assertEquals("pobi", names.get(0));
        assertEquals("woni", names.get(1));
        assertEquals("jun", names.get(2));
    }

    @Test
    public void 쉼표가_없는_잘못된_입력_테스트(){
        String invalidInput = "pobi woni jun";
        assertThatThrownBy(() -> Input.splitName(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}