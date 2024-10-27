package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarServiceTest {

    private final RacingCarService racingCarService = new RacingCarService();

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {","})
    void 빈_문자열_예외_발생(String inputString) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> racingCarService.makeCarList(inputString));
    }

    @ParameterizedTest
    @ValueSource(strings = {"jewan"})
    void 자동차_수_부족_예외_발생(String inputString) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> racingCarService.makeCarList(inputString));
    }

    @ParameterizedTest
    @ValueSource(strings = {"jewan,jewan"})
    void 중복_문자열_예외_발생(String inputString) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> racingCarService.makeCarList(inputString));
    }

    @ParameterizedTest
    @ValueSource(strings = {"jewan,taekbae"})
    void 자동차_이름_길이_초과_예외_발생(String inputString) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> racingCarService.makeCarList(inputString));
    }
}
