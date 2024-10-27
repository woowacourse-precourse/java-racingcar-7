package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Racingcar;
import racingcar.model.Racingcars;
import racingcar.service.RacingService;
import racingcar.utils.StringReplacer;
import racingcar.utils.StringSplitter;
import racingcar.validate.RacingcarAttemptValidate;
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
    private RacingcarAttemptValidate racingcarAttemptValidate;

    @BeforeEach
    void setUp() {
        this.stringReplacer = new StringReplacer();
        this.stringSplitter = new StringSplitter();
        this.racingcars = new Racingcars();
        this.racingService = new RacingService(racingcars);
        this.racingcarNameValidate = new RacingcarNameValidate();
        this.racingcarAttemptValidate = new RacingcarAttemptValidate();
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void inputCarName() {
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
    void isCarNameBlank() {
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

    @Test
    @DisplayName("시도 횟수 입력 테스트")
    void inputAttempt() {
        /* Given */
        String input = "5";

        /* When */
        racingcarAttemptValidate.isBlank(input);
        racingcarAttemptValidate.isParsable(input);
        int attempt = Integer.parseInt(input);

        /* Then */
        assertThat(attempt).isEqualTo(5);
    }

    @Test
    @DisplayName("시도 횟수 공백 입력 예외 테스트")
    void isAttemptBlank() {
        /* Given */
        String input = "    ";

        /* When, Then */
        assertThatThrownBy(()->racingcarAttemptValidate.isBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수 공백");
    }

    @Test
    @DisplayName("정수 이외 입력 예외 처리")
    void isAttemptParsable() {
        /* Given */
        String input = " 1  5 ";

        /* When, Then */
        assertThatThrownBy(()->racingcarAttemptValidate.isParsable(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 정수 이외 데이터 입력");
    }

    @Test
    @DisplayName("동시 우승자 출력 테스트")
    void duplecateWinner(){
        /* Given*/
        racingcars.addCar(new Racingcar("녹차","---"));
        racingcars.addCar(new Racingcar("말차","---"));
        racingcars.addCar(new Racingcar("마차","---"));
        racingcars.addCar(new Racingcar("주차","---"));

        /* When */
        String winners = racingService.makeFinalResult();

        /* Then */
        assertThat(winners).isEqualTo("녹차, 말차, 마차, 주차");
    }
}