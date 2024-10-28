package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.utils.Parser;

public class ValidatorTest {

    @Test
    void 입력값이_빈_값이에요() {
        //given
        List<String> testList = Arrays.asList("");
        //when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateCarNameBlank(testList);
        });
        assertEquals("[ERROR] 입력값이 비었습니다.", exception.getMessage());
    }

    @Test
    void 입력값이_최대값을_초과했어요(){
        List<String> testList = Arrays.asList("어라입력","값이초과","해버렸어요.");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNameLength(testList);
        });
        assertEquals("[ERROR] 입력값이 최대 글자수(5자)를 초과하였습니다.",exception.getMessage());
    }

    @Test
    void 입력값중에서_중복된_이름이_있어요(){
        List<String> testList = Arrays.asList("남석","남석","김남석");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->{
            Validator.validateDuplicatedCarName(testList);
        });
        assertEquals("[ERROR] 입력값 중에 중복된 이름이 있습니다.", exception.getMessage());
    }
}
