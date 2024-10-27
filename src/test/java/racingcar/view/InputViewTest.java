package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.close;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.config.GameConstant.CAR_NAME_DELIMITER;
import static racingcar.config.GameErrorMessage.EMPTY_NAME_MESSAGE;
import static racingcar.view.InputView.getCarNames;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private static String getTestString(String[] carNames) {
        List<String> carNameList = Arrays.asList(carNames);
        StringBuilder testString = new StringBuilder();

        Iterator<String> iterator = carNameList.iterator();
        while (iterator.hasNext()) {
            testString.append(iterator.next()); // 현재 요소 추가
            if (iterator.hasNext()) { // 다음 요소가 있으면 ,
                testString.append(CAR_NAME_DELIMITER);
            }
        }

        return testString.toString();
    }

    @AfterEach
    void tearDown() {
        close();
    }

    @Test
    void 자동차_이름_입력() {
        String[] expectedResult = {"car1", "car2", "car3"};
        String testString = getTestString(expectedResult);

        System.setIn(generateUserInput(testString));
        String[] actualResult = getCarNames();

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void 구분자_연속_입력() {
        String[] carNames = {"car", "", "car1"}; // "car,,car1"
        String testString = getTestString(carNames);
        System.setIn(generateUserInput(testString));

        assertThatThrownBy(InputView::getCarNames)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_NAME_MESSAGE);
    }

    @Test
    void 공백_이름_입력() {
        String[] carNames = {"car", " ", "car1"}; // "car, ,car1"
        String testString = getTestString(carNames);
        System.setIn(generateUserInput(testString));

        assertThatThrownBy(InputView::getCarNames)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_NAME_MESSAGE);
    }

    @Test
    void 구분자로_시작하는_입력() {
        String[] carNames = {"", "car"}; // ",car"
        String testString = getTestString(carNames);
        System.setIn(generateUserInput(testString));

        assertThatThrownBy(InputView::getCarNames)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_NAME_MESSAGE);
    }

    @Test
    void 구분자로_끝나는_입력() {
        String[] carNames = {"car", ""};
        String testString = getTestString(carNames);
        System.setIn(generateUserInput(testString));

        assertThatThrownBy(InputView::getCarNames)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_NAME_MESSAGE);
    }
}