package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.CarNameValidator;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
