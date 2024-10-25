package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;
import racingcar.service.CarRaceService;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final CarRaceService service = new CarRaceService();

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("우승자가 없는 경우")
    void NoWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("최종 우승자 :");
                },
                STOP, STOP
        );
    }

    @Test
    @DisplayName("경기 횟수가 null 혹은 Empty인 경우")
    void CarNameNullOrEmpty() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.init("", "5"));
        assertEquals("Null 혹은 공백 문자가 포함되었습니다.", ex.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 길이가 5를 초과한 경우")
    void CarNameOverLength() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.init("overLength", "5"));
        assertEquals("자동차 이름 길이가 5를 초과했습니다.", ex.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 특수 문자가 포함된 경우")
    void CarNameIncludeRegex() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.init("name%", "5"));
        assertEquals("특수 문자가 포함되었습니다.", ex.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 중복됨")
    void CarNameSameName() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.init("test, test", "5"));
        assertEquals("동일한 이름의 자동차가 존재합니다.", ex.getMessage());
    }

    @Test
    @DisplayName("자동차 경주 최대 경기 횟수를 넘김")
    void CarRaceOver() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.init("car", "11"));
        assertEquals("허용된 게임 횟수를 넘겼습니다.", ex.getMessage());
    }

    @Test
    @DisplayName("자동차 경주 입력 값이 음수")
    void CarRaceInputNegative() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.init("car", "-1"));
        assertEquals("경기 횟수는 음수가 될 수 없습니다.", ex.getMessage());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
