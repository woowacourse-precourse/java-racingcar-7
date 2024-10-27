package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.close;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.view.InputView.getCarNames;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @AfterEach
    void tearDown() {
        close();
    }

    @Test
    void 자동차_이름_입력() {
        String testString = "car1,car2,car3";
        String[] expectedResult = {"car1", "car2", "car3"};
        System.setIn(generateUserInput(testString));
        String[] actualResult = getCarNames();

        assertThat(actualResult).isEqualTo(expectedResult);
    }

}