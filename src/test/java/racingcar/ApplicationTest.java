package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;


class ApplicationTest extends NsTest {
    private final Application application = new Application();

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

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"   "})
    void validateNotEmpty_예외_테스트(String input) {
        assertThatThrownBy(() -> application.validateNotEmpty(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNotEmpty_정상_입력_테스트() {
        assertThatCode(() -> application.validateNotEmpty("hello"))
                .doesNotThrowAnyException();
    }

    @Test
    void validateMinimumTwoCars_예외_테스트() {
        String[] onlyOneCar = {"onlyMe"};
        assertThatThrownBy(() -> application.validateMinimumTwoCars(onlyOneCar))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateMinimumTwoCars_정상_입력_테스트() {
        String[] twoCars = {"Me", "andMe"};

        assertThatCode(() -> application.validateMinimumTwoCars(twoCars))
                .doesNotThrowAnyException();
    }

    @Test
    void validateUniqueCarName_예외_테스트() {
        String[] duplicateCarNames = {"Car-1", "Car-1", "Car-2"};
        application.initializeCarPositions(duplicateCarNames);

        assertThatThrownBy(() -> application.validateUniqueCarName(duplicateCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateUniqueCarName_정상_입력_테스트() {
        String[] carNames = {"Car-1", "Car-2", "Car-3"};
        application.initializeCarPositions(carNames);

        assertThatCode(() -> application.validateUniqueCarName(carNames))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"carName", "여섯글자이름"})
    void validateNameLength_예외_테스트(String name) {
        assertThatThrownBy(() -> application.validateNameLength(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "fifth"})
    void validateNameLength_정상_입력_테스트(String name) {
        assertThatCode(() -> application.validateNameLength(name))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "!", "a", "아 ", "4$", "  %"})
    void validateIntInput_예외_테스트(String userInput) {
        assertThatThrownBy(() -> application.validateIntInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void initializeCarPositions_자동차_위치_초기화_테스트() {
        String[] carNames = {"Car-1", "Car-2", "Car-3"};
        application.initializeCarPositions(carNames);

        for (String carName : carNames) {
            assertThat(application.carPositions.get(carName)).isEqualTo(0);
        }
    }

    @Test
    void moveCarForward_자동차_전진_테스트() {
        String[] carNames = {"Car-1", "Car-2", "Car-3"};
        application.initializeCarPositions(carNames);

        for (String carName : carNames) {
            application.moveCarForward(carName);
            assertThat(application.carPositions.get(carName)).isEqualTo(1);
        }
    }

    @Test
    void printRoundResult_한_회차_결과_출력_테스트() {
        String[] carNames = {"Car-1", "Car-2", "Car-3"};
        application.initializeCarPositions(carNames);

        application.moveCarForward("Car-1");
        application.moveCarForward("Car-1");
        application.moveCarForward("Car-2");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        for (String car : carNames) {
            application.printRoundResult(car);
        }

        System.setOut(System.out);

        assertThat(outputStream.toString()).contains("Car-1 : --", "Car-2 : -", "Car-3 : ");
    }

    @Test
    void getWinnerList_우승자_선정_테스트() {
        String[] carNames = {"Car-1", "Car-2", "Car-3"};
        application.initializeCarPositions(carNames);

        application.moveCarForward("Car-1");
        application.moveCarForward("Car-2");

        assertThat(application.getWinnerList()).contains("Car-1", "Car-2");
    }

    @Test
    void printWinner_우승자_출력_테스트() {
        List<String> winner = List.of("Car-1", "Car-2");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        application.printWinner(winner);
        System.setOut(System.out);

        assertThat(outputStream.toString()).contains("최종 우승자 : Car-1, Car-2");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}