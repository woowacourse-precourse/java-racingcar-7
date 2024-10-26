package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Racingcars;
import racingcar.service.RacingService;
import racingcar.utils.StringReplacer;
import racingcar.utils.StringSplitter;
import racingcar.validate.RacingcarNameValidate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingControllerTest {

    private StringReplacer stringReplacer;
    private StringSplitter stringSplitter;
    private RacingService racingService;
    private Racingcars racingcars;
    private RacingcarNameValidate racingcarNameValidate;

    @BeforeEach
    void setUp() {
        this.stringReplacer = new StringReplacer();
        this.stringSplitter = new StringSplitter();
        this.racingcars = new Racingcars();
        this.racingService = new RacingService(racingcars);
        this.racingcarNameValidate = new RacingcarNameValidate();
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

    @Test
    @DisplayName("자동차 이름 공백 입력 테스트")
    void isBlank() {
        /* Given */
        String input = " ";

        /* When, Then */
        assertThatThrownBy(() -> racingcarNameValidate.isBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름 공백");
    }

    @Test
    @DisplayName("자동차 이름 공백 제거 테스트")
    void removeSpaces() {
        /* Given */
        String input = "녹차, 녹차,     녹차";

        /* When, Then */
        assertThat(stringReplacer.removeSpaces(input)).isEqualTo("녹차,녹차,녹차");
    }

    @Test
    @DisplayName("자동차 이름 5글자 초과 입력 예외 테스트")
    void isMoreThanFiveLetters() {
        /* Given */
        List<String> inputList = List.of("녹차3456", "녹차34567");

        /* When, Then */
        assertThatThrownBy(() -> racingcarNameValidate.isMoreThanFiveLetters(inputList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름 글자수 초과");
    }

    @Test
    @DisplayName("자동차 이름 중복 입력 예외 테스트")
    void isDuplicate() {
        /* Given */
        List<String> inputList = List.of("녹차", "녹차");

        /* When, Then */
        assertThatThrownBy(() -> racingcarNameValidate.isDuplicate(inputList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름 중복");
    }
}