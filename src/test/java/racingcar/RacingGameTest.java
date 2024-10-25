package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {
    private Cars cars;

    @BeforeEach
    void beforeEach() {
        cars = new Cars();
    }

    @DisplayName("자동차 이름이 영어가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"히포"," "," test","test1","123"})
    void 자동차_이름_영어만_사용_테스트(String input) {
        assertThatThrownBy(() -> Car.from(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 길이가 빈 값이거나 5글자를 초과하는 경우 예외가 발생한다")
    @ParameterizedTest
    @EmptySource
    @NullSource
    @ValueSource(strings = {"I'm hippo"})
    void 자동차_이름_길이_테스트(String input) {
        assertThatThrownBy(() -> Car.from(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 중복되는 경우 예외가 발생한다")
    @Test
    void 자동차_이름_중복_테스트() {
        List<String> names = List.of("Hippo","Hippo","B","C");

        assertThatThrownBy(() -> cars.registerAll(names)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 10개를 초과하는 경우 예외가 발생한다")
    @Test
    void 자동차_이름_최대_개수_테스트() {
        List<String> names = List.of("A","B","C","D","E","F","G","H","I","J","K");

        assertThatThrownBy(() -> cars.registerAll(names)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 1개인 경우 예외가 발생한다")
    @Test
    void 자동차_이름_최소_개수_테스트() {
        List<String> names = List.of("A");
        assertThatThrownBy(() -> cars.registerAll(names)).isInstanceOf(IllegalArgumentException.class);
    }
}