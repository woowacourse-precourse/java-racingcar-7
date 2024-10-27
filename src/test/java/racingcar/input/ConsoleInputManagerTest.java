package racingcar.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.error.ErrorCode;

class ConsoleInputManagerTest {

    private ConsoleInputManager consoleInputManager;

    @BeforeEach
    void setUp() {
        consoleInputManager = new ConsoleInputManager();
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    private void setSystemInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void 자동차_이름_목록을_정상적으로_가져온다() {
        // given
        setSystemInput("car1,car2,car3\n");

        // when
        List<Car> cars = consoleInputManager.getCars();

        // then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
        assertThat(cars.get(2).getName()).isEqualTo("car3");
    }

    @Test
    void 쉼표_앞뒤로_공백이_있는_경우_자동차_이름_목록을_정상적으로_가져온다() {
        // given
        setSystemInput("car1 , car2 ,car3 \n");

        // when
        List<Car> cars = consoleInputManager.getCars();

        // then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
        assertThat(cars.get(2).getName()).isEqualTo("car3");
    }

    @Test
    void 유효하지_않은_자동차_이름_목록일_경우_예외가_발생한다() throws NoSuchFieldException, IllegalAccessException {
        // given
        setSystemInput("car1,toolongname,car3\n");

        int minNameLength = getMinNameLength();
        int maxNameLength = getMaxNameLength();

        String expectedMessage = ErrorCode.INVALID_CAR_NAME.getMessage(minNameLength, maxNameLength);

        // when & then
        assertThatThrownBy(() -> consoleInputManager.getCars())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @Test
    void 유효한_시도_횟수를_정상적으로_가져온다() {
        // given
        setSystemInput("5\n");

        // when
        long attemptCount = consoleInputManager.getAttemptCount();

        // then
        assertThat(attemptCount).isEqualTo(5L);
    }

    @Test
    void 유효하지_않은_시도_횟수일_경우_예외가_발생한다() throws NoSuchFieldException, IllegalAccessException {
        // given
        setSystemInput("0\n");

        int minAttemptCount = getMinAttemptCount();
        String expectedMessage = ErrorCode.INVALID_ATTEMPT_COUNT.getMessage(minAttemptCount);

        // when & then
        assertThatThrownBy(() -> consoleInputManager.getAttemptCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    private int getMinAttemptCount() throws NoSuchFieldException, IllegalAccessException {
        Field minAttemptCountField = AttemptCountValidator.class.getDeclaredField("MIN_ATTEMPT_COUNT");
        minAttemptCountField.setAccessible(true);
        return (int) minAttemptCountField.get(null);
    }

    private int getMinNameLength() throws NoSuchFieldException, IllegalAccessException {
        Field minNameLengthField = NameValidator.class.getDeclaredField("MIN_NAME_LENGTH");
        minNameLengthField.setAccessible(true);
        return (int) minNameLengthField.get(null);
    }

    private int getMaxNameLength() throws NoSuchFieldException, IllegalAccessException {
        Field maxNameLengthField = NameValidator.class.getDeclaredField("MAX_NAME_LENGTH");
        maxNameLengthField.setAccessible(true);
        return (int) maxNameLengthField.get(null);
    }
}
