package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void validateStartEnd() {
        String carNames = "Karina,Winter,Giselle,Ningning,";
        assertThatThrownBy(() -> Application.validateStartEnd(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateDuplication() {
        String[] namesByComma = new String[] {"Karina", "Winter", "Winter", "Giselle", "Ningning"};
        assertThatThrownBy(() -> Application.validateDuplication(namesByComma))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateLength() {
        String name = "NingNing";
        assertThatThrownBy(() -> Application.validateLength(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateEmpty() {
        String emptyName = "";
        assertThatThrownBy(() -> Application.validateEmpty(emptyName))
                .isInstanceOf(IllegalArgumentException.class);

        String nullName = null;
        assertThatThrownBy(() -> Application.validateEmpty(nullName))
                .isInstanceOf(IllegalArgumentException.class);

        String blankSpaceName = "      ";
        assertThatThrownBy(() -> Application.validateEmpty(blankSpaceName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidName() {
        String carNames = "Karin,Winte,Gisel,NingN";
        assertThat(Application.isValidName(carNames)).isTrue();
    }

    @Test
    void isValidName_fail() {
        String longCarName = "Karina,Winter,Giselle,NingNing";
        assertThatThrownBy(() -> Application.isValidName(longCarName))
                .isInstanceOf(IllegalArgumentException.class);

        String duplicateName = "Karin,Wint,Wint,Gis,Ning";
        assertThatThrownBy(() -> Application.isValidName(duplicateName))
                .isInstanceOf(IllegalArgumentException.class);

        String emptyName = "Karin,Win,,Gis";
        assertThatThrownBy(() -> Application.isValidName(emptyName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
