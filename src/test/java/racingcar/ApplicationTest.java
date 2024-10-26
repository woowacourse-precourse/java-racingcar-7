package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constants.Constants;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RoundValidator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constants.Constants.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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

    @DisplayName("자동차 이름이 공백일 시 검증테스트")
    @Test
    void 자동차_목록_검증_테스트1() {
        CarNameValidator carNameValidator = new CarNameValidator("pobi,,jun");

        assertThatThrownBy(carNameValidator::verify)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_LENGTH_ERROR);
    }

    @DisplayName("자동차 이름이 5글자 이상일 시 검증테스트")
    @Test
    void 자동차_목록_검증_테스트2() {
        CarNameValidator carNameValidator = new CarNameValidator("pobi,woniwoni,jun");

        assertThatThrownBy(carNameValidator::verify)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_LENGTH_ERROR);
    }

    @DisplayName("자동차 이름이 중복일 시 검증테스트")
    @Test
    void 자동차_목록_검증_테스트3() {
        CarNameValidator carNameValidator = new CarNameValidator("pobi,pobi,jun");

        assertThatThrownBy(carNameValidator::verify)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_DUPLICATE_ERROR);
    }

    @DisplayName("자동차리스트 값이 잘못된 패턴일 시 검증테스트1")
    @Test
    void 자동차_목록_검증_테스트4() {
        CarNameValidator carNameValidator = new CarNameValidator("pobi,woni,jun,");

        assertThatThrownBy(carNameValidator::verify)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_WRONG_ERROR);
    }

    @DisplayName("자동차리스트 값이 잘못된 패턴일 시 검증테스트2")
    @Test
    void 자동차_목록_검증_테스트5() {
        CarNameValidator carNameValidator = new CarNameValidator(",pobi,woni,jun");

        assertThatThrownBy(carNameValidator::verify)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_WRONG_ERROR);
    }

    @DisplayName("자동차리스트 값이 잘못된 패턴일 시 검증테스트3")
    @Test
    void 자동차_목록_검증_테스트6() {
        CarNameValidator carNameValidator = new CarNameValidator(",pobi,woni,jun,");

        assertThatThrownBy(carNameValidator::verify)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_WRONG_ERROR);
    }

    @Test
    void 자동차_목록_테스트1() {
        CarNameValidator carNameValidator = new CarNameValidator("pobi,woni,jun");
        carNameValidator.verify();

        assertThat(carNameValidator.getCarList()).hasSize(3).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 자동차_목록_테스트2() {
        CarNameValidator carNameValidator = new CarNameValidator("안녕,잘지냈니,잘가,다음에,또,보자");
        carNameValidator.verify();

        assertThat(carNameValidator.getCarList()).hasSize(6).containsExactly("안녕", "잘지냈니", "잘가", "다음에", "또", "보자");
    }

    @Test
    void 자동차_목록_테스트3() {
        CarNameValidator carNameValidator = new CarNameValidator("one,일,1");
        carNameValidator.verify();

        assertThat(carNameValidator.getCarList()).hasSize(3).containsExactly("one", "일", "1");
    }

    @DisplayName("시도 횟수의 입력값이 숫자인 경우 테스트1")
    @Test
    void 시도_횟수_테스트1() {
        RoundValidator roundValidator = new RoundValidator("4");
        roundValidator.verify();

        assertThat(roundValidator.getRound()).isEqualTo(4);
    }

    @DisplayName("시도 횟수의 입력값이 숫자인 경우 테스트2")
    @Test
    void 시도_횟수_테스트2() {
        RoundValidator roundValidator = new RoundValidator("13");
        roundValidator.verify();

        assertThat(roundValidator.getRound()).isEqualTo(13);
    }

    @DisplayName("시도 횟수의 입력값이 숫자가 아닐 시 예외테스트1")
    @Test
    void 시도_횟수_테스트3() {
        assertThatThrownBy(() -> new RoundValidator("abc"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ROUND_NUMBER_WRONG_ERROR);
    }

    @DisplayName("시도 횟수의 입력값이 숫자가 아닐 시 예외테스트2")
    @Test
    void 시도_횟수_테스트4() {
        assertThatThrownBy(() -> new RoundValidator("가나다"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ROUND_NUMBER_WRONG_ERROR);
    }

    @DisplayName("시도 횟수의 입력값이 숫자가 아닐 시 예외테스트3")
    @Test
    void 시도_횟수_테스트5() {
        assertThatThrownBy(() -> new RoundValidator("!@#"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ROUND_NUMBER_WRONG_ERROR);
    }

    @DisplayName("시도 횟수의 입력값이 숫자가 아닐 시 예외테스트4")
    @Test
    void 시도_횟수_테스트6() {
        assertThatThrownBy(() -> new RoundValidator("a가!"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ROUND_NUMBER_WRONG_ERROR);
    }

    @DisplayName("시도 횟수의 입력값이 음수일 시 예외테스트")
    @Test
    void 시도_횟수_테스트7() {
        RoundValidator roundValidator = new RoundValidator("-6");

        assertThatThrownBy(roundValidator::verify)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ROUND_NUMBER_WRONG_ERROR);
    }

    @DisplayName("시도 횟수의 입력값이 0 일 시 예외테스트")
    @Test
    void 시도_횟수_테스트8() {
        RoundValidator roundValidator = new RoundValidator("0");

        assertThatThrownBy(roundValidator::verify)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ROUND_NUMBER_WRONG_ERROR);
    }

    @DisplayName("전체 경기 작동 테스트1")
    @Test
    void 전체_테스트1() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "4");
                assertThat(output()).contains("pobi : ---", "woni : -", "jun : ---", "최종 우승자 : pobi,jun");
            },
            MOVING_FORWARD, STOP,           MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            STOP,           STOP,           STOP,
            MOVING_FORWARD, STOP,           MOVING_FORWARD
        );
    }

    @DisplayName("전체 경기 작동 테스트2")
    @Test
    void 전체_테스트2() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun,chris", "5");
                assertThat(output()).contains("pobi : ", "woni : ---", "jun : --", "chris : ----", "최종 우승자 : chris");
            },
            STOP, MOVING_FORWARD, STOP,           MOVING_FORWARD,
            STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            STOP, MOVING_FORWARD, STOP,           MOVING_FORWARD,
            STOP, STOP,           MOVING_FORWARD, STOP,
            STOP, STOP,           STOP,           MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
