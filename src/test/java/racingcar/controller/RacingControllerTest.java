package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Racingcars;
import racingcar.service.RacingService;
import racingcar.utils.StringSplitter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingControllerTest {

    private StringSplitter stringSplitter;
    private RacingService racingService;
    private Racingcars racingcars;

    @BeforeEach
    void setUp() {
        this.stringSplitter = new StringSplitter();
        this.racingcars = new Racingcars();
        this.racingService = new RacingService(racingcars);
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void run() {
        /* Given */
        String input = "녹차,말차,유자차,차차차";
        /* When */
        List<String> inputList = stringSplitter.split(input);
        racingService.saveCarName(inputList);
        /* Then */
        assertThat(inputList).containsExactly("녹차", "말차", "유자차", "차차차");
        assertThat(racingcars.getRacingcarList())
                .extracting("name")
                .containsExactly("녹차", "말차", "유자차", "차차차")
                .hasSize(4);
    }
}