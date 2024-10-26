package racingcar.progress;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Progress;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgressTest {

    @Test
    @DisplayName("Progress에 새로운 단계가 추가되면 값이 변경된다")
    void addStep() {
        Progress progress = new Progress("");
        Progress newProgress = progress.addStep("-");
        assertThat(newProgress.getValue()).isEqualTo("-");
    }
}
