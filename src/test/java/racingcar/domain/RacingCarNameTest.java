package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"yoni", "ini", "nini", "zzang"})
    @DisplayName("자동차 이름 테스트")
    void test_name_constructor_success(String input) {
        // when
        RacingCarName racingCarName = new RacingCarName(input);
        // then
        assertThat(racingCarName.racingCarName()).isEqualTo(input);
    }
    @ParameterizedTest
    @ValueSource(strings = {"","doggang", "hyuntoo"})
    @DisplayName("자동차 이름은 1자리 이상 5자 이하만 가능합니다.")
    void test_name_constructor_fail_over_length_name(String racingCarName) {
        // given
        String expectedMessage = "자동차 이름은 1자리 이상 5자 이하만 가능합니다.";
        // when & then
        assertThatThrownBy(() -> new RacingCarName(racingCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}