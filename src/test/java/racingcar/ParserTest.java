package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    public void 자동차이름목록_쉼표기준분리_5글자이하_테스트() throws Exception {
        //Given
        String carNames = "pobi,woni,jun";

        //When, Then
        Assertions.assertThatCode(() -> Parser.parseCarNames(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    public void 자동차이름목록_쉼표_외_문자기준분리_5글자이하_예외테스트() throws Exception {
        //Given
        String carNames = "pobi,woni:jun";

        //When
        Assertions.assertThatCode(() -> Parser.parseCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Parser.CAR_NAME_LENGTH_EXCEPTION_MSG);
    }

    @Test
    public void 자동차이름_중복허용_테스트() throws Exception {
        //Given
        String carNames = "pobi,pobi,pobi";

        //When, Then
        Assertions.assertThatCode(() -> Parser.parseCarNames(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    public void 시도횟수_테스트() throws Exception {
        //Given
        String attempts = "5";
        int expected = 5;

        //When
        int actual = Parser.parseAttempts(attempts);

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 시도횟수_int범위초과_예외테스트() throws Exception {
        //Given
        String attempts = Long.toString(Long.MAX_VALUE);

        //When, Then
        Assertions.assertThatThrownBy(() -> Parser.parseAttempts(attempts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Parser.ATTEMPTS_RANGE_EXCEPTION_MSG);
    }

    @Test
    public void 시도횟수_음수_예외테스트() throws Exception {
        //Given
        String attempts = "-1";

        //When, Then
        Assertions.assertThatThrownBy(() -> Parser.parseAttempts(attempts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Parser.ATTEMPTS_RANGE_EXCEPTION_MSG);
    }
}