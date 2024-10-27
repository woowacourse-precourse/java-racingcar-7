package racingcar.support.splitter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("구분기 테스트")
class SplitterTest {

    @Test
    @DisplayName("문자열을 구분한다")
    void 성공_구분() {
        // Given
        String delimiter = ",";
        Splitter splitter = new Splitter(delimiter);
        String text = "mint,dobby";

        // When
        String[] names = splitter.splitFrom(text);

        // Then
        assertAll(
                () -> assertThat(names[0]).isEqualTo("mint"),
                () -> assertThat(names[1]).isEqualTo("dobby")
        );
    }
}
