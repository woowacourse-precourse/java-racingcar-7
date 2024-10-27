package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
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

    @Test
    void 테스트_1_1_자동차_이름_입력() {
        String simulatedInput = "a,b,c,d\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);

        String carNamesInputString = Application.getCarNamesInputString();

        assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        assertThat(carNamesInputString).isEqualTo("a,b,c,d");
    }

    @Test
    void 테스트_1_2_쉼표로_이름_구분() {
        String carNamesInputString = "a,b,c,d";
        String[] carNames = Application.getCarNames(carNamesInputString);

        assertThat(carNames).isEqualTo(new String[]{"a","b","c","d"});
    }
    @Test
    void 테스트_1_2_이름이_하나만_입력된_경우() {
        String carNamesInputString = "abcd";
        String[] carNames = Application.getCarNames(carNamesInputString);

        assertThat(carNames).isEqualTo(new String[]{"abcd"});
    }
    @Test
    void 테스트_1_2_공백이_포함된_이름() {
        String carNamesInputString = "a b, c d ,e ,f  ";
        String[] carNames = Application.getCarNames(carNamesInputString);

        assertThat(carNames).isEqualTo(new String[]{"a b", " c d ", "e ", "f  "});
    }
    @Test
    void 테스트_1_2_이름이_길이_0인_경우() {
        String carNamesInputString = "a,,b";
        String[] carNames = Application.getCarNames(carNamesInputString);

        assertThat(carNames).isEqualTo(new String[]{"a", "", "b"});
    }

    @Test
    void 테스트_1_3_유효한_이름() {
        String carNamesInputString = ",a,bc,def,ghij,klmno";
        String[] carNames = Application.getCarNames(carNamesInputString);

        assertThatNoException().isThrownBy(() -> Application.validateCarNames(carNames));
    }
    @Test
    void 테스트_1_3_유효하지_않은_이름() {
        String carNamesInputString = ",a,bc,def,ghij,klmno,pqrstu";
        String[] carNames = Application.getCarNames(carNamesInputString);

        assertThatThrownBy(() -> Application.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 테스트_1_4_carList_생성() {
        String[] carNames = {"a", "b", "c"};
        ArrayList<Car> carList = Application.createCarList(carNames);

        assertThat(carList.size()).isEqualTo(3);
        assertThat(carList.get(0).getName()).isEqualTo("a");
        assertThat(carList.get(1).getName()).isEqualTo("b");
        assertThat(carList.get(2).getName()).isEqualTo("c");
    }

    @Test
    void 테스트_2_1_시도할_횟수_입력() {
        String simulatedInput = "10\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);

        String tryCountInputString = Application.getTryCountInputString();

        assertThat(output()).contains("시도할 횟수는 몇 회인가요?");
        assertThat(tryCountInputString).isEqualTo("10");
    }

    @Test
    void 테스트_2_2_유효한_시도할_횟수() {
        String tryCountInputString = "10";

        assertThatNoException().isThrownBy(() -> Application.getTryCount(tryCountInputString));
        assertThat(Application.getTryCount(tryCountInputString)).isEqualTo(10);
    }
    @Test
    void 테스트_2_2_정수로_변환할_수_없는_입력() {
        String tryCountInputString = "abcd";

        assertThatThrownBy(() -> Application.getTryCount(tryCountInputString))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 테스트_2_2_양의_정수가_아닌_입력() {
        String tryCountInputString = "-10";

        assertThatThrownBy(() -> Application.getTryCount(tryCountInputString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 테스트_3_1_난수값에_따라_전진_정지_확인() {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("a"));
        carList.add(new Car("b"));
        carList.add(new Car("c"));

        assertRandomNumberInRangeTest(
                () -> {
                    Application.proceedTurn(carList);
                    assertThat(carList.get(0).getDistance()).isEqualTo(1);
                    assertThat(carList.get(1).getDistance()).isEqualTo(0);
                    assertThat(carList.get(2).getDistance()).isEqualTo(0);
                },
                MOVING_FORWARD, STOP, STOP
        );
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
