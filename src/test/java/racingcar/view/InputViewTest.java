package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    InputView inputView;
    InputStream originalIn;

    @BeforeEach
    void setup(){
        inputView = new InputView();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }
    @Test
    void 입력_파싱_테스트() {
        //when
        String simulatedInput = "car1,car2,car3\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        List<String> nameList = inputView.getNameList();

        assertEquals(Arrays.asList("car1", "car2", "car3"), nameList);

    }

    @Test
    void 이름_5자_초과입력() {
        //when
        String simulatedInput = "car1,LONGNAME";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertThatThrownBy(inputView::getNameList)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_미입력() {
        //when
        String simulatedInput = "car1,,,";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertThatThrownBy(inputView::getNameList)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_중복() {
        //when
        String simulatedInput = "car1,car1";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertThatThrownBy(inputView::getNameList)
                .isInstanceOf(IllegalArgumentException.class);
    }
}