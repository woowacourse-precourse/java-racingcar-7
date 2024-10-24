package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;

class RacingCarControllerTest {
    static RacingCarController racingCarController;
    static InputView inputView = InputView.getInstance();

    @BeforeAll
    static void setUp() {
        racingCarController = new RacingCarController(new RacingCarService());
    }

    @DisplayName("이름이 4자를 넘어갈 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = "pobi,woni,abcde")
    void validateNameLength(String names) {
        List<String> nameList = inputView.splitNames(names);
        assertThatThrownBy(() -> racingCarController.setCarsName(nameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

}