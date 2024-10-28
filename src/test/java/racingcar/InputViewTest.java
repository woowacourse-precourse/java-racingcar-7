package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import java.util.LinkedHashMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    InputView inputView = new InputView();

    @Test
    @DisplayName("[기능_테스트]-자동차이름_입력")
    void getCarMap_success() {
        //given
        String input = "pobi,woni,jun";

        //when
        LinkedHashMap<String, Car> map = inputView.convertInputToMap(input);

        //then
        Assertions.assertThat(map).containsKeys("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("[예외_테스트]-자동차이름_입력(이름중복)")
    void getCarMap_exception_duplicateName() {
        //given
        String input = "pobi,woni,jun,jun,woni";

        //when
        Throwable throwable = catchThrowable(() -> inputView.convertInputToMap(input));

        //then
        Assertions.assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[예외_테스트]-자동차이름_입력(6자이상)")
    void getCarMap_exception_overMaxLength() {
        //given
        String input = "pobipobi,woni,jun";

        //when
        Throwable throwable = catchThrowable(() -> inputView.convertInputToMap(input));

        //then
        Assertions.assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[예외_테스트]-자동차이름_입력(이름입력X)")
    void getCarMap_exception_noNameInput() {
        //given
        String input = ",,,";

        //when
        Throwable throwable = catchThrowable(() -> inputView.convertInputToMap(input));

        //then
        Assertions.assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[예외_테스트]-자동차이름_입력(입력X)")
    void getCarMap_exception_nInput() {
        //given
        String input = "";

        //when
        Throwable throwable = catchThrowable(() -> inputView.convertInputToMap(input));

        //then
        Assertions.assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[기능_테스트]-시도할횟수_입력")
    void getRoundNumber_success() {
        //given
        String input = "12345";

        //when
        Long num = inputView.convertInputToLong(input);

        //then
        Assertions.assertThat(num).isEqualTo(12345L);
    }

    @Test
    @DisplayName("[예외_테스트]-시도할횟수_입력(long변환불가)")
    void getRoundNumber_exception_WrongNumberFormat() {
        //given
        String input = "1sbc!2";

        //when
        Throwable throwable = catchThrowable(() -> inputView.convertInputToLong(input));

        //then
        Assertions.assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[예외_테스트]-시도할횟수_입력(음수, 0)")
    void getRoundNumber_exception_NotPositiveNumber() {
        //given
        String inputMinus = "-1";
        String inputZero = "0";

        //when
        Throwable thrownMinusInput = catchThrowable(() -> inputView.convertInputToLong(inputMinus));
        Throwable thrownZeroInput = catchThrowable(() -> inputView.convertInputToLong(inputZero));

        //then
        Assertions.assertThat(thrownMinusInput).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThat(thrownZeroInput).isInstanceOf(IllegalArgumentException.class);
    }
}
