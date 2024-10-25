package racingcar.front.view;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.front.exception.InvalidCarNameInputException;
import racingcar.front.exception.InvalidPlayCountException;
import racingcar.global.dto.CarRaceRequestDTO;

class InputViewTest {

    private final InputView inputView = new InputView();
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        // sout을 가로 채기 위함
        System.setOut(new PrintStream(byteArrayOutputStream));
        Console.close();
    }

    @ParameterizedTest
    @MethodSource("validTestInput")
    @DisplayName("valid한 두 번의 문자열 입력을 입력을 파싱")
    void 문자열_파싱_테스트(ByteArrayInputStream in, List<String> expectedCarNames, Integer expectedPlayCount) {
        //given
        //Scanner nextLine에 입력할 값
        System.setIn(in);
        //when
        CarRaceRequestDTO carRaceRequestDTO = inputView.readUserInput();
        //then
        assertThat(carRaceRequestDTO.carNames()).containsAll(expectedCarNames);
        assertThat(carRaceRequestDTO.gamePlayCount()).isEqualTo(expectedPlayCount);
    }

    @Test
    @DisplayName("자동차 이름이 5개 이상인 경우 예외 발생")
    void 문자열_파싱_예외_테스트1() {
        //given
        //Scanner nextLine에 입력할 값
        System.setIn(new ByteArrayInputStream("asdasd, asda, asdeq\n5".getBytes()));
        //when
        //then
        assertThatThrownBy(inputView::readUserInput).isInstanceOf(InvalidCarNameInputException.class);
    }

    @Test
    @DisplayName("숫자가 들어오지 않았을 때 예외 발생")
    void 문자열_파싱_예외_테스트2() {
        //given
        //Scanner nextLine에 입력할 값
        System.setIn(new ByteArrayInputStream("asda,asda,asdeq\naas".getBytes()));
        //when
        //then
        assertThatThrownBy(inputView::readUserInput).isInstanceOf(InvalidPlayCountException.class);
    }

    private static final List<String> inputs = List.of("asd,qwe,zxc\n5");
    private static final List<List<String>> expectedCarNames = List.of(List.of("asd", "qwe", "zxc"));
    private static final List<Integer> expectedPlayCounts = List.of(5);

    static Stream<Arguments> validTestInput() {
        return Stream.of(Arguments.of(new ByteArrayInputStream(inputs.get(0).getBytes()), expectedCarNames.get(0),
                expectedPlayCounts.get(0)));
    }


}