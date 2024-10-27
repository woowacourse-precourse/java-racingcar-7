package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.CarsNameParser.parse;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsNameParserTest {


    @Test
    @DisplayName("자동차 목록 문자열을 \",\" 기준으로 구분한다: 기능 목록 1번")
    void 이름을_컴마_기준_분리() {
        //given
        String input = "pobi,ddot,teddy";
        //when
        Set<String> carsName = parse(input);
        //then
        assertEquals(Set.of("pobi", "ddot", "teddy"), carsName);
    }

    @Test
    @DisplayName("이름이 중복되면 하나로 여긴다.")
    void 이름_중복시_하나만() {
        //given
        String input = "pobi,ddot,pobi";
        //when
        Set<String> carsName = parse(input);
        //then
        assertEquals(Set.of("pobi", "ddot"), carsName);
        assertEquals(Set.of("ddot", "pobi"), carsName);
        assertEquals(Set.of("ddot", "pobi"), carsName);

        //중복도 허용하지 않고 이름의 순서를 상관하지 않는다,
    }

    @Test
    @DisplayName("빈 값이 아니고 공백이 포함되지 않은 5자 미만은 유효하다")
    void 이런_이름도_가능() {
        testNameParsing(Set.of("귀엽다", "이쁘다"), "귀엽다,이쁘다");
        testNameParsing(Set.of("213", "2134"), "213,2134");
        testNameParsing(Set.of("!!", ";\\\""), "!!,;\\\"");
    }

    @Test
    @DisplayName("빈 입력과 공백 문자는 예외를 발생시킨다.")
    void 이런_경우_예외() {
        // 아무 입력이 없음
        testNameParsingThrow("");
        testNameParsingThrow("pobi,");
        // 공백이 있으면 예외
        testNameParsingThrow(" ");
        // 이름 중간에 공백이 있어도 예외
        testNameParsingThrow("pobi,dd ot");
        // 이름 끝에 공백이 있어도 예외
        testNameParsingThrow("pobi,ddot ");
        // 이름 앞에 공백이 있어도 예외
        testNameParsingThrow("pobi, ddot");
    }


    @Test
    @DisplayName("이름이 5자가 넘으면 예외")
    void 이름_5자_이상() {
        testNameParsingThrow("ddotzy,pobi");
    }


    void testNameParsing(Set<String> carsName, String input) {
        assertEquals(carsName, parse(input));
    }

    void testNameParsingThrow(String input) {
        assertThrows(IllegalArgumentException.class, () -> parse(input));
    }


}