package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Map;

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

    @Test
    void validateNumberFormat() {
        String numberWithCharacters = "a1b";
        assertThatThrownBy(() -> Application.validateNumberFormat(numberWithCharacters))
                .isInstanceOf(IllegalArgumentException.class);

        String negativeNumber = "-2";
        assertThatThrownBy(() -> Application.validateNumberFormat(negativeNumber))
                .isInstanceOf(IllegalArgumentException.class);

        String zero = "0";
        assertThatThrownBy(() -> Application.validateNumberFormat(zero))
                .isInstanceOf(IllegalArgumentException.class);

        String empty = "";
        assertThatThrownBy(() -> Application.validateNumberFormat(empty))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBound() {
        String bigNumber = "2147483648";
        assertThatThrownBy(() -> Application.validateBound(bigNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidTryCount() {
        String inputTryCount = "42";
        assertThat(Application.isValidTryCount(inputTryCount))
                .isTrue();
    }

    @Test
    void isValidTryCount_fail() {
        String numberWithCharacters = "a1b";
        assertThatThrownBy(() -> Application.isValidTryCount(numberWithCharacters))
                .isInstanceOf(IllegalArgumentException.class);

        String negativeNumber = "-2";
        assertThatThrownBy(() -> Application.isValidTryCount(negativeNumber))
                .isInstanceOf(IllegalArgumentException.class);

        String zero = "0";
        assertThatThrownBy(() -> Application.isValidTryCount(zero))
                .isInstanceOf(IllegalArgumentException.class);

        String empty = "";
        assertThatThrownBy(() -> Application.isValidTryCount(empty))
                .isInstanceOf(IllegalArgumentException.class);

        String bigNumber = "123456789123456789";
        assertThatThrownBy(() -> Application.isValidTryCount(bigNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createResultMap() {
        String carNames = "Karina,Winter,Giselle,NingNing";

        Map<String, StringBuilder> resultMap = Application.createResultMap(carNames);

        assertThat(resultMap).hasSize(4);
        assertThat(resultMap).containsKeys("Karina", "Winter", "Giselle", "NingNing");
        assertThat(resultMap.get("Karina").toString()).isEmpty();
        assertThat(resultMap.get("Winter").toString()).isEmpty();
        assertThat(resultMap.get("Giselle").toString()).isEmpty();
        assertThat(resultMap.get("NingNing").toString()).isEmpty();
    }
}
