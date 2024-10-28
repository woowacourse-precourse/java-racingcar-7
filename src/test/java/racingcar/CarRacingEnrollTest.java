package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarRacingEnrollTest {

    @Test
    public void 자동차이름목록_쉼표기준분리_5글자이하_테스트() throws Exception {
        //Given
        CarRacingEnroll carRacingEnroll = new CarRacingEnroll();
        String input = "pobi,woni,jun";

        // When
        CarGroup carGroup = carRacingEnroll.createCarGroup(input);

        //Then
        Assertions.assertThat(carGroup).isNotNull();
    }

    @Test
    public void 자동차이름목록_쉼표기준분리_빈이름_예외테스트() throws Exception {
        //Given
        CarRacingEnroll carRacingEnroll = new CarRacingEnroll();
        String input = "pobi,,woni";

        //When, Then
        Assertions.assertThatCode(() -> carRacingEnroll.createCarGroup(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarRacingEnroll.CAR_NAME_LENGTH_EXCEPTION_MSG);
    }

    @Test
    public void 자동차이름목록_쉼표_외_문자기준분리_5글자초과_예외테스트() throws Exception {
        //Given
        CarRacingEnroll carRacingEnroll = new CarRacingEnroll();
        String input = "pobi,woni:jun";

        //When, Then
        Assertions.assertThatCode(() -> carRacingEnroll.createCarGroup(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarRacingEnroll.CAR_NAME_LENGTH_EXCEPTION_MSG);
    }

    @Test
    public void 자동차이름_중복허용_테스트() throws Exception {
        //Given
        CarRacingEnroll carRacingEnroll = new CarRacingEnroll();
        String input = "pobi,pobi,pobi";

        // When
        CarGroup carGroup = carRacingEnroll.createCarGroup(input);

        //Then
        Assertions.assertThat(carGroup).isNotNull();
    }

    @Test
    public void 시도횟수_테스트() throws Exception {
        //Given
        CarRacingEnroll carRacingEnroll = new CarRacingEnroll();
        String input = "5";
        int expected = 5;

        //When
        int actual = carRacingEnroll.extractAttempt(input);

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 시도횟수_int범위초과_예외테스트() throws Exception {
        //Given
        CarRacingEnroll carRacingEnroll = new CarRacingEnroll();
        String input = Long.toString(Long.MAX_VALUE);

        //When, Then
        Assertions.assertThatCode(() -> carRacingEnroll.extractAttempt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarRacingEnroll.ATTEMPT_RANGE_EXCEPTION_MSG);
    }

    @Test
    public void 시도횟수_음수_예외테스트() throws Exception {
        //Given
        CarRacingEnroll carRacingEnroll = new CarRacingEnroll();
        String input = "-1";

        //When, Then
        Assertions.assertThatCode(() -> carRacingEnroll.extractAttempt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarRacingEnroll.ATTEMPT_RANGE_EXCEPTION_MSG);
    }
}