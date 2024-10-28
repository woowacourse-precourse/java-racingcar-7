package racingcar.controller.handler;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.InputParser;
import racingcar.dto.RaceRequestDTO;

class ConsoleInputHandlerTest {

    private ConsoleInputHandler consoleInputHandler;
    private InputParser parser;

    @BeforeEach
    void setUp() {
        parser = new InputParser();
    }

    @Test
    @DisplayName("정상 입력이 주어졌을 때 RaceRequestDTO를 반환한다.")
    void 정상_입력_RaceRequestDTO_반환_테스트() {
        TestInputProvider testInputProvider = new TestInputProvider("123,456,789", "4");
        consoleInputHandler = new ConsoleInputHandler(parser, testInputProvider);

        RaceRequestDTO raceRequest = consoleInputHandler.getRaceRequest();

        Assertions.assertThat(raceRequest.getTimes()).isEqualTo(4);
        Assertions.assertThat(raceRequest.getNames()).hasSize(3).containsExactly("123", "456", "789");
    }

    @Test
    @DisplayName("이름 앞 뒤로 공백이 있는 정상 입력이 주어졌을 때 RaceRequestDTO를 반환한다.")
    void 이름_앞뒤로_공백_있는_정상_입력_RaceRequestDTO_반환_테스트() {
        TestInputProvider testInputProvider = new TestInputProvider(" 123 , 456 , 789 ", "4");
        consoleInputHandler = new ConsoleInputHandler(parser, testInputProvider);

        RaceRequestDTO raceRequest = consoleInputHandler.getRaceRequest();

        Assertions.assertThat(raceRequest.getTimes()).isEqualTo(4);
        Assertions.assertThat(raceRequest.getNames()).hasSize(3).containsExactly("123", "456", "789");
    }

    @Test
    @DisplayName("이름 입력이 공백일 때 IllegalArgumentException 반환한다.")
    void 이름_공백_입력_예외_테스트() {
        TestInputProvider testInputProvider = new TestInputProvider(" ", "4");
        consoleInputHandler = new ConsoleInputHandler(parser, testInputProvider);

        Assertions.assertThatThrownBy(() -> consoleInputHandler.getRaceRequest())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("횟수 입력이 공백일 때 IllegalArgumentException 반환한다.")
    void 횟수_공백_입력_예외_테스트() {
        TestInputProvider testInputProvider = new TestInputProvider("123,456,789", "");
        consoleInputHandler = new ConsoleInputHandler(parser, testInputProvider);

        Assertions.assertThatThrownBy(() -> consoleInputHandler.getRaceRequest())
                .isInstanceOf(IllegalArgumentException.class);
    }
}