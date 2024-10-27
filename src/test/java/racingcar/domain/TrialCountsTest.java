package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.validator.TrialCountsValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class TrialCountsTest {

    @Test
    void 시도_횟수_셋팅_테스트() {
        //given
        TrialCountsValidator validator = new TrialCountsValidator();
        TrialCounts trialCounts = new TrialCounts("5", validator);

        //when
        int counts = trialCounts.getTrialCounts();

        //then
        assertThat(counts).isEqualTo(5);
    }
}
