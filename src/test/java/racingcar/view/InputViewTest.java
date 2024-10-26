package racingcar.view;

import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import camp.nextstep.edu.missionutils.Console;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InputViewTest {

    private InputStream originalSystemIn;
    private InputView inputView;

    @BeforeEach
    void setUp() {
        originalSystemIn = System.in;
        inputView = new InputView();
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
        Console.close();
    }

    @Test
    @DisplayName("정상적인 자동차 이름 입력 시 리스트 크기와 내용이 정확해야 한다.")
    void 올바른_자동차_이름_입력() {
        simulateConsoleInput("car1,car2,car3");
        List<String> carNames = inputView.getCarNames();
        assertEquals(3, carNames.size());
        assertTrue(carNames.contains("car1"));
        assertTrue(carNames.contains("car2"));
        assertTrue(carNames.contains("car3"));
    }

    @Test
    @DisplayName("빈 문자열 입력 시 예외가 발생해야 한다.")
    void 빈_문자열_입력_예외() {
        simulateConsoleInput(" ");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                inputView::getCarNames);
        assertEquals("자동차 이름은 빈 문자열이나 공백을 포함할 수 없습니다.", thrown.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 빈 문자열이 포함되면 예외가 발생해야 한다.")
    void 빈문자열_포함된_자동차_이름_예외() {
        simulateConsoleInput("car1, ,car3");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                inputView::getCarNames);
        assertEquals("자동차 이름은 빈 문자열이나 공백을 포함할 수 없습니다.", thrown.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 제어 문자가 포함되면 예외가 발생해야 한다.")
    void 제어문자_포함된_자동차_이름_예외() {
        simulateConsoleInput("car1,car\t2,car3");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                inputView::getCarNames);
        assertEquals("자동차 이름에 공백이나 제어 문자는 포함될 수 없습니다.", thrown.getMessage());
    }

    @Test
    @DisplayName("5자를 초과하는 자동차 이름 입력 시 예외가 발생해야 한다.")
    void 이름_5자_초과_입력_예외() {
        simulateConsoleInput("car1,car2,car3longname");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                inputView::getCarNames);
        assertEquals("자동차 이름은 5자 이하여야 합니다.", thrown.getMessage());
    }

    @Test
    @DisplayName("시도 횟수에 숫자가 아닌 값이 입력되면 예외가 발생해야 한다.")
    void 숫자_아닌_시도횟수_입력_예외() {
        simulateConsoleInput("abc");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                inputView::getNumberOfRounds);
        assertEquals("숫자를 입력해야 합니다.", thrown.getMessage());
    }

    private void simulateConsoleInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
