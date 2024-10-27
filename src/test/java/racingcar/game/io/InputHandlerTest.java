package racingcar.game.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.game.error.ErrorMessage;
import racingcar.game.model.AttemptCount;
import racingcar.game.model.RacingCars;

@DisplayName("InputHandler 를 테스트한다")
class InputHandlerTest {

    private InputHandler inputHandler = new InputHandler();

    @BeforeEach
    void setUpInput() {
        inputHandler = new InputHandler();
    }

    @AfterEach
    void resetInput() {
        Console.close();
    }

    @DisplayName("성공 테스트를 검증한다.")
    @Nested
    class GetCarsFromUser {

        @DisplayName("자동차 이름이 , 로 구분되어있다면 성공한다.")
        @ParameterizedTest
        @ValueSource(strings = {"one,two,three"})
        void testGetCarsFromUser(String input) {
            // given
            InputStream inputStream = createInput(input);
            System.setIn(inputStream);

            // when
            RacingCars racingCars = inputHandler.getCarsFromUser();

            // then
            assertThat(racingCars).isNotNull();
        }

        @DisplayName("시도 횟수가 숫자면 성공한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1"})
        void testAttemptCountFromUser(String input) {
            // given
            InputStream inputStream = createInput(input);
            System.setIn(inputStream);

            // when
            AttemptCount attemptCount = inputHandler.getAttemptCountFromUser();

            // then
            assertThat(attemptCount).isNotNull();
        }
    }

    @DisplayName("실패 테스트를 검증한다.")
    @Nested
    class GetAttemptCountFromUser {

        @DisplayName("자동차 이름 입력값이 공백이면 실패한다.")
        @ParameterizedTest
        @ValueSource(strings = {" ", "  "})
        void testGetCarsFromUserIsBlank(String input) {
            // given
            InputStream inputStream = createInput(input);
            System.setIn(inputStream);

            // when & then
            assertThatThrownBy(() -> inputHandler.getCarsFromUser())
                    .isExactlyInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_INPUT.getDescription());
        }

        @DisplayName("자동차 이름 입력값이 비어있으면 실패한다.")
        @ParameterizedTest
        @ValueSource(strings = "\n")
        void testGetCarsFromUserIsEmpty(String input) {
            // given
            InputStream inputStream = createInput(input);
            System.setIn(inputStream);

            // when & then
            assertThatThrownBy(() -> inputHandler.getCarsFromUser())
                    .isExactlyInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_INPUT.getDescription());
        }

        @DisplayName("시도 횟수 입력값이 공백이면 실패한다.")
        @ParameterizedTest
        @ValueSource(strings = {" ", "  "})
        void testAttemptCountFromUserBlank(String input) {
            // given
            InputStream inputStream = createInput(input);
            System.setIn(inputStream);

            // when & then
            assertThatThrownBy(() -> inputHandler.getAttemptCountFromUser())
                    .isExactlyInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_INPUT.getDescription());
        }

        @DisplayName("시도 횟수 입력값이 비어있으면 실패한다.")
        @ParameterizedTest
        @ValueSource(strings = "\n")
        void testAttemptCountFromUserEmpty(String input) {
            // given
            InputStream inputStream = createInput(input);
            System.setIn(inputStream);

            // when & then
            assertThatThrownBy(() -> inputHandler.getAttemptCountFromUser())
                    .isExactlyInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_INPUT.getDescription());
        }

        @DisplayName("시도 횟수가 숫자가 아니면 실패한다.")
        @ParameterizedTest
        @ValueSource(strings = {"string"})
        void testAttemptCountFromUserType(String input) {
            // given
            InputStream inputStream = createInput(input);
            System.setIn(inputStream);

            // when & then
            assertThatThrownBy(() -> inputHandler.getAttemptCountFromUser())
                    .isExactlyInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.ATTEMPT_COUNT_TYPE.getDescription());
        }
    }

    private InputStream createInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}