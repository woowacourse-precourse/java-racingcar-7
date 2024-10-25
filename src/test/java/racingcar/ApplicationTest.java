package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RoundValidator;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Disabled("완성이후 테스트할 것")
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

    @Disabled("완성이후 테스트할 것")
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
        CarNameValidator carNameValidator = new CarNameValidator();
        List<String> carList = List.of("pobi", "", "jun");

        assertThatThrownBy(() -> carNameValidator.nameLength(carList))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 5글자 이상일 시 검증테스트")
    @Test
    void 자동차_목록_검증_테스트2() {
        CarNameValidator carNameValidator = new CarNameValidator();
        List<String> carList = List.of("pobi", "woniwoni", "jun");

        assertThatThrownBy(() -> carNameValidator.nameLength(carList))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 중복일 시 검증테스트")
    @Test
    void 자동차_목록_검증_테스트3() {
        CarNameValidator carNameValidator = new CarNameValidator();
        List<String> carList = List.of("pobi", "pobi", "jun");

        assertThatThrownBy(() -> carNameValidator.nameOverlap(carList))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차리스트 값이 잘못된 패턴일 시 검증테스트1")
    @Test
    void 자동차_목록_검증_테스트4() {
        CarNameValidator carNameValidator = new CarNameValidator();
        String cars = "pobi,woni,jun,";

        assertThatThrownBy(() -> carNameValidator.rightNamePattern(cars))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차리스트 값이 잘못된 패턴일 시 검증테스트2")
    @Test
    void 자동차_목록_검증_테스트5() {
        CarNameValidator carNameValidator = new CarNameValidator();
        String cars = ",pobi,woni,jun";

        assertThatThrownBy(() -> carNameValidator.rightNamePattern(cars))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차리스트 값이 잘못된 패턴일 시 검증테스트3")
    @Test
    void 자동차_목록_검증_테스트6() {
        CarNameValidator carNameValidator = new CarNameValidator();
        String cars = ",pobi,woni,jun,";

        assertThatThrownBy(() -> carNameValidator.rightNamePattern(cars))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_목록_테스트1() {
        String cars = "pobi,woni,jun";
        List<String> carList = List.of(cars.split(","));
        CarNameValidator check = new CarNameValidator();

        check.rightNamePattern(cars);
        check.nameLength(carList);
        check.nameOverlap(carList);

        assertThat(carList).hasSize(3).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 자동차_목록_테스트2() {
        String cars = "안녕,잘지냈니,잘가,다음에,또,보자";
        List<String> carList = List.of(cars.split(","));
        CarNameValidator check = new CarNameValidator();

        check.rightNamePattern(cars);
        check.nameLength(carList);
        check.nameOverlap(carList);

        assertThat(carList).hasSize(6).containsExactly("안녕", "잘지냈니", "잘가", "다음에", "또", "보자");
    }

    @Test
    void 자동차_목록_테스트3() {
        String cars = "one,일,1";
        List<String> carList = List.of(cars.split(","));
        CarNameValidator check = new CarNameValidator();

        check.rightNamePattern(cars);
        check.nameLength(carList);
        check.nameOverlap(carList);

        assertThat(carList).hasSize(3).containsExactly("one", "일", "1");
    }

    @DisplayName("시도 횟수의 입력값이 숫자인 경우 테스트1")
    @Test
    void 시도_횟수_테스트1() {
        RoundValidator check = new RoundValidator();

        int number = check.parseInt("4");
        check.positiveNumber(number);

        assertThat(number).isEqualTo(4);
    }

    @DisplayName("시도 횟수의 입력값이 숫자인 경우 테스트2")
    @Test
    void 시도_횟수_테스트2() {
        RoundValidator check = new RoundValidator();

        int number = check.parseInt("13");
        check.positiveNumber(number);

        assertThat(number).isEqualTo(13);
    }

    @DisplayName("시도 횟수의 입력값이 숫자가 아닐 시 예외테스트1")
    @Test
    void 시도_횟수_테스트3() {
        RoundValidator check = new RoundValidator();

        assertThatThrownBy(() -> check.parseInt("abc"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수의 입력값이 숫자가 아닐 시 예외테스트2")
    @Test
    void 시도_횟수_테스트4() {
        RoundValidator check = new RoundValidator();

        assertThatThrownBy(() -> check.parseInt("가나다"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수의 입력값이 숫자가 아닐 시 예외테스트3")
    @Test
    void 시도_횟수_테스트5() {
        RoundValidator check = new RoundValidator();

        assertThatThrownBy(() -> check.parseInt("!@#"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수의 입력값이 숫자가 아닐 시 예외테스트4")
    @Test
    void 시도_횟수_테스트6() {
        RoundValidator check = new RoundValidator();

        assertThatThrownBy(() -> check.parseInt("a가!"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수의 입력값이 음수일 시 예외테스트")
    @Test
    void 시도_횟수_테스트7() {
        RoundValidator check = new RoundValidator();

        assertThatThrownBy(() -> check.positiveNumber(check.parseInt("-6")))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수의 입력값이 0 일 시 예외테스트")
    @Test
    void 시도_횟수_테스트8() {
        RoundValidator check = new RoundValidator();

        assertThatThrownBy(() -> check.positiveNumber(check.parseInt("0")))
            .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
