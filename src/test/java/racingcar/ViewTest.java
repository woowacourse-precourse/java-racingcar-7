package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.constants.Constants.Messages;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ViewTest extends NsTest {

    @Test
    void checkInput_유효테스트() {
        List<String> validInput = List.of("Adam", "Ivan", "Harry");

        assertThatCode(() -> InputView.checkInput(validInput))
                .doesNotThrowAnyException();
    }

    @Test
    void checkInput_5자이상_글자_에러테스트() {
        List<String> invalidInput = List.of("Adam", "Ivan", "Benjamin");

        assertThatThrownBy(() -> InputView.checkInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.INPUT_LENGTH_ERROR);
    }

    @Test
    void checkInput_list비어있는_경우_에러테스트() {
        List<String> invalidInput = List.of();

        assertThatThrownBy(() -> InputView.checkInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.NO_INPUT_ERROR);
    }

    @Test
    void checkInput_list에_빈문자열만_있는_경우_에러테스트() {
        List<String> invalidInput = List.of("");

        assertThatThrownBy(() -> InputView.checkInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.NO_INPUT_ERROR);
    }

    @Test
    void readCarNames_유효테스트() {
        String input = "Adam,Ivan,Harry";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> result = InputView.readCarNames();

        assertThat(result).containsExactly("Adam", "Ivan", "Harry");
    }

    @Test
    void readCount_유효테스트(){
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(InputView.readCount()).isEqualTo(5);
    }

    @Test
    void printOnceCarResult_유효테스트() {
        Car car1 = new Car("Adam");
        Car car2 = new Car("Ivan");
        car1.moveForward();
        car1.moveForward();
        car2.moveForward();
        List<Car> cars = List.of(car1, car2);

        OutputView.printOnceCarResult(cars);

        String expectedOutput = "Adam : --\n"
                + "Ivan : -";
        assertThat(output()).isEqualTo(expectedOutput);
    }

    @Test
    void printWinners_PrintsWinners() {
        Car car1 = new Car("Adam");
        Car car2 = new Car("Ivan");
        car1.moveForward();
        car1.moveForward();
        car2.moveForward();
        List<Car> cars = List.of(car1, car2);

        OutputView.printWinners(cars);

        String expectedOutput = "최종 우승자 : Adam, Ivan";
        assertThat(output()).isEqualTo(expectedOutput);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
