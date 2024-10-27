package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.INVALID_COUNT_RANGE;
import static racingcar.exception.ErrorMessage.INVALID_NAME_COUNT;
import static racingcar.exception.ErrorMessage.INVALID_NAME_LENGTH;
import static racingcar.exception.ErrorMessage.NAME_DUPLICATE;
import static racingcar.exception.ErrorMessage.NOT_INTEGER;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;


class ViewTest {

    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    @DisplayName("getCarNames - 5글자보다 긴 이름이 있으면 예외가 발생해야한다.")
    void nameLengthMoreThan5() {
        // given
        String input = "asdasddasd,sad,sdsd";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when & then
        assertThatThrownBy(View::getCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NAME_LENGTH.getMessage());

    }

    @Test
    @DisplayName("getCarNames - 빈 이름이 있으면 예외가 발생해야한다.")
    void hasBlankName() {
        // given
        InputStream in = System.in;
        String input = "assd, ,sdsd";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when & then
        assertThatThrownBy(View::getCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NAME_LENGTH.getMessage());
    }

    @Test
    @DisplayName("getCarNames - 입력에 중복이 있을 경우 예외가 발생해야한다.")
    void hasDuplicateName() {
        // given
        String input = "assd,assd ,sdsd";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when & then
        assertThatThrownBy(View::getCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("getCarNames - 자동차 이름이 2개 미만으로 들어오면 예외가 발생해야한다.")
    void onlyOneName() {
        // given
        String input = "assd";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when & then
        assertThatThrownBy(View::getCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NAME_COUNT.getMessage());
    }

    @Test
    @DisplayName("getCarNames - 정상적인 입력에서는 이름 리스트를 정상적으로 반환해야한다.")
    void success() {
        // given
        String input = "aaaa,bbbb,cc";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when
        List<String> carNames = View.getCarNames();
        // then
        assertThat(carNames.size()).isEqualTo(3);
        assertThat(carNames).containsExactly("aaaa", "bbbb", "cc");
    }

    @Test
    @DisplayName("getCount - 숫자가 아닌 값이 들어오면 예외가 발생해야한다.")
    void noInteger() {
        // given
        String input = "asd";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when & then
        assertThatThrownBy(View::getCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_INTEGER.getMessage());
    }

    @Test
    @DisplayName("getCount - 1보다 작은 값이 들어가면 예외가 발생해야한다.")
    void lessThan1() {
        // given
        String input = "0";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when & then
        assertThatThrownBy(View::getCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_COUNT_RANGE.getMessage());
    }

    @Test
    @DisplayName("getCount - 정상 값에 대해서는 Integer가 정상적으로 반환되어야한다.")
    void successGetCount() {
        // given
        String input = "2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when
        int count = View.getCount();
        // then
        assertThat(count).isEqualTo(2);
    }

    @Test
    @DisplayName("getCount - 숫자 앞 뒤 공백은 제거 후 숫자를 반환해야한다.")
    void successTrim() {
        // given
        String input = "   2   ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when
        int count = View.getCount();
        // then
        assertThat(count).isEqualTo(2);
    }

    @Test
    @DisplayName("showResult - 차들의 상태를 정확히 출력해야한다.")
    void showResult() {
        // given
        List<Car> cars = createCars();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        //when
        View.showResult(cars);
        //then
        String output = outputStream.toString();
        assertThat(output)
                .contains("실행 결과")
                .contains("aaa : ")
                .contains("bbb : ")
                .contains("ccc : ");
    }

    @Test
    @DisplayName("showFinalResult - 차들의 상태를 보고 우승자를 정확히 출력해야한다.")
    void showFinalResult() {
        // given
        List<Car> cars = createCars();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        //when
        View.showFinalResult(cars);
        //then
        String output = outputStream.toString();
        assertThat(output).contains("최종 우승자 : aaa, bbb, ccc");

    }

    private List<Car> createCars() {
        return List.of(Car.of("aaa"), Car.of("bbb"), Car.of("ccc"));
    }
}