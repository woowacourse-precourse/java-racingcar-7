package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoveConditionCheckerTest {
    private MoveConditionChecker moveConditionChecker;
    private TestNumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        this.numberGenerator = new TestNumberGenerator();
        this.moveConditionChecker = new MoveConditionChecker(numberGenerator);
    }

    @ParameterizedTest
    @CsvSource(value = {"4", "5", "6", "7", "8", "9"})
    @DisplayName("숫자생성기가 4이상을 생성하면 전진조건을 만족한다.")
    void canMove(int number) {
        numberGenerator.setNumber(number);
        assertThat(moveConditionChecker.canMove()).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "1", "2", "3"})
    @DisplayName("숫자생성기가 4미만 생성하면 전진조건을 만족시키지 못한다.")
    void cannotMove(int number) {
        numberGenerator.setNumber(number);
        assertThat(moveConditionChecker.canMove()).isFalse();
    }
}
