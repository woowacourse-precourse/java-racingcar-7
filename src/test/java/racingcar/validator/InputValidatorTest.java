package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

@DisplayName("[유닛 테스트] - 입력 값 검증")
class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("자동차 이름 입력 - 자동차 이름 미 입력 시 예외 발생")
    void emptyCarName_validate_throwException() {
        //given
        ArrayList<String> carNameList = new ArrayList<>();
        carNameList.add("");

        //when
        Throwable throwable = catchThrowable(() -> inputValidator.validateCarName(carNameList));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("이름이 없는 자동차는 존재할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름 입력 - 자동차 이름에 공백 포함 시 예외 발생")
    void carNameContainingSpace_validate_throwException() {
        //given
        ArrayList<String> carNameList = new ArrayList<>();
        carNameList.add("pobi");
        carNameList.add(" woni");
        carNameList.add("jun");

        //when
        Throwable throwable = catchThrowable(() -> inputValidator.validateCarName(carNameList));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("자동차 이름엔 공백을 포함할 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("provideInvalidCarNameCase")
    @DisplayName("자동차 이름 입력 - 형식에 맞지 않는 자동차 이름 입력 시 예외 발생")
    void invalidCarName_validate_throwException(ArrayList<String> carNameList) {
        //given & when
        Throwable throwable = catchThrowable(() -> inputValidator.validateCarName(carNameList));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("자동차 이름은 한글 또는 영문으로만 가능하며 , 를 제외한 특수문자는 사용할 수 없습니다.");
    }

    static Stream<Arguments> provideInvalidCarNameCase() {
        return Stream.of(
                Arguments.arguments(new ArrayList<>(List.of("pobi1", "woni", "jun"))),
                Arguments.arguments(new ArrayList<>(List.of("pobi", "woni&", "jun")))
        );
    }

    @Test
    @DisplayName("자동차 이름 입력 - 자동차 이름 최대 길이 초과 시 예외 발생")
    void MaxLoopCountOver_validate_throwException() {
        //given
        ArrayList<String> carNameList = new ArrayList<>();
        carNameList.add("pobiking");

        //when
        Throwable throwable = catchThrowable(() -> inputValidator.validateCarName(carNameList));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("자동차 이름의 길이는 최대 5글자 입니다.");
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("반복 횟수 입력 - 반복 횟수 미입력 시 예외 발생")
    void emptyLoopCount_throwException(String loopCount) {
        //given & when
        Throwable throwable = catchThrowable(() -> inputValidator.validateLoopCount(loopCount));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("반복할 횟수는 필수 입력 값 입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" 1", "d", "pobi"})
    @DisplayName("반복 횟수 입력 - 형식에 맞지 않는 반복 횟수 입력 시 예외 발생")
    void invalidLoopCount_throwException(String loopCount) {
        //given & when
        Throwable throwable = catchThrowable(() -> inputValidator.validateLoopCount(loopCount));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("반복할 횟수는 1 이상의 정수로만 입력 가능합니다.");
    }
}