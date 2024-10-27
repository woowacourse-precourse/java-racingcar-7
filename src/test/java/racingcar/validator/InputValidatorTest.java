package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.exception.InputException;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {

    @Test
    void Parse_Name_기본_작동_테스트(){
        List<String> nameList = InputValidator.parseNames("pobi, seuk");

        assertThat(nameList)
                .hasSize(2) // 리스트의 크기 검사
                .contains("pobi")   // 포함 여부
                .containsExactly("pobi", "seuk");   // 순서까지 동일하게 값이 제대로 들어갔는지
    }

    @Test
    void Parse_Turns_기본_작동_테스트(){
        int num = InputValidator.parseTurns("1");

        assertThat(num)
                .isOne()
                .isPositive(); // 양수인지
    }

    @Test
    void 공백_문자_AND_널_값_예외처리(){
        assertThatThrownBy(() -> InputValidator.parseNames(" "))
                .isInstanceOf(InputException.class) // 반환 형식?
                .hasMessage("빈 문자열입니다.");   // 어떤 문자열을 반환하는지
    }

    @Test
    void 이름_길이_5글자_예외처리(){
        assertThatThrownBy(() -> InputValidator.parseNames("sususu"))
                .isInstanceOf(InputException.class)
                .hasMessage("이름의 길이는 5자 이하여야 합니다.");
    }

}
