package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"yoni", "ini", "nini", "zzang"})
    @DisplayName("racing car name test")
    void test_name_constructor_success(String input) {
        // when
        RacingCarName racingCarName = new RacingCarName(input);
        // then
        assertThat(racingCarName.racingCarName()).isEqualTo(input);
    }
    @ParameterizedTest
    @ValueSource(strings = {"","doggang", "hyuntoo"})
    @DisplayName("racing car name 예외 상황 확인 (한자리 ~ 5자리가 아닌 것) ")
    void test_name_constructor_fail_over_length_name(String racingCarName) {
        // given
        String expectedMessage = "자동차이름은 1자리이상 5자 이하만 가능합니다.";
        // when & then
        assertThatThrownBy(() -> new RacingCarName(racingCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}