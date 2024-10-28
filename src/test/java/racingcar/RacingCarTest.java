package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNamesErrorMessage;
import racingcar.exception.RaceCountsErrorMessage;
import racingcar.exception.RaceCountsException;
import racingcar.validation.CarNamesValidation;
import racingcar.validation.RaceCountsValidation;

class RacingCarTest extends NsTest {
    private void assertThrowsIllegalArgumentException(ThrowableAssert.ThrowingCallable callable, String expectedMessage) {
        Assertions.assertThatThrownBy(callable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    private void assertThrowsRaceCountsException(ThrowableAssert.ThrowingCallable callable, String expectedMessage) {
        Assertions.assertThatThrownBy(callable)
                .isInstanceOf(RaceCountsException.class)
                .hasMessageContaining(expectedMessage);
    }

    @Test
    @DisplayName("자동차 이름이 5글자 초과로 작성된 경우 IllegalArgumentException")
    void 글자_수_초과_예외_테스트() {
        assertThrowsIllegalArgumentException(() ->
                        new CarNamesValidation().validateCarNames("forky,eundeangdmf"),
                CarNamesErrorMessage.CAR_NAME_OVER_FIVE.getMessage()
        );
    }

    @Test
    @DisplayName("쉼표(,)가 아닌 구분자가 작성된 경우 IllegalArgumentException")
    void 구분자_예외_테스트() {
        assertThrowsIllegalArgumentException(() ->
                        new CarNamesValidation().validateCarNames("joy;sad"),
                CarNamesErrorMessage.INVALID_DELIMITER.getMessage()
        );
    }

    @Test
    @DisplayName("자동차 이름이 비어 있는 경우 IllegalArgumentException")
    void 빈_자동차_이름_예외_테스트() {
        assertThrowsIllegalArgumentException(() ->
                        new CarNamesValidation().validateCarNames(""),
                CarNamesErrorMessage.CAR_NAME_EMPTY.getMessage()
        );
    }

    @Test
    @DisplayName("자동차 이름이 중복되는 경우 IllegalArgumentException")
    void 중복_자동차_이름_예외_테스트() {
        assertThrowsIllegalArgumentException(() ->
                        new CarNamesValidation().validateCarNames("ham,dog,ham,hot"),
                CarNamesErrorMessage.DUPLICATE_CAR_NAME.getMessage()
        );
    }

    @Test
    @DisplayName("이동 횟수가 비어 있는 경우 RaceCountsException")
    void 빈_이동_횟수_예외_테스트() {
        assertThrowsRaceCountsException(() ->
                        new RaceCountsValidation().validateRaceCounts(""),
                RaceCountsErrorMessage.COUNT_EMPTY.getMessage()
        );
    }

    @Test
    @DisplayName("이동 횟수에 입력한 값이 숫자가 아닌 경우 RaceCountsException")
    void 숫자가_아닌_이동_횟수_예외_테스트() {
        assertThrowsRaceCountsException(() ->
                        new RaceCountsValidation().validateRaceCounts("ab"),
                RaceCountsErrorMessage.COUNT_NOT_INTEGER.getMessage()
        );
    }

    @Test
    @DisplayName("이동 횟수에 입력한 값이 양수가 아닌 경우 RaceCountsException")
    void 양수가_아닌_이동_횟수_예외_테스트() {
        assertThrowsRaceCountsException(() ->
                        new RaceCountsValidation().validateRaceCounts("-1"),
                RaceCountsErrorMessage.COUNT_NEGATIVE.getMessage()
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}