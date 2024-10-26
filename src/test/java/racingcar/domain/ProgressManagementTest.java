package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProgressManagementTest {

    @Test
    @DisplayName("시도 횟수를 입력할 경우 게임 진행 상황을 관리하는 ProgressManagement 객체가 생성된다.")
    void create() {
        // given
        int max = 1;

        // when
        ProgressManagement progressManagement = new ProgressManagement(max);

        // then
        assertThat(progressManagement).isNotNull();
    }

    @Test
    @DisplayName("현재 시도한 횟수가 최대 진행할 수 있는 횟수보다 작을 경우 true를 반환한다.")
    void isProgress() {
        // given
        int max = 1;
        ProgressManagement progressManagement = new ProgressManagement(max);

        // when
        boolean result = progressManagement.isProgress();

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("현재 시도한 횟수가 최대 진행할 수 있는 횟수보다 크거나 같을 경우 false를 반환한다.")
    void isNotProgress() {
        // given
        int max = 1;
        ProgressManagement progressManagement = new ProgressManagement(max);
        progressManagement.incrementTryCount();

        // when
        boolean result = progressManagement.isProgress();

        // then
        assertThat(result).isFalse();
    }
    @Test
    @DisplayName("현재 진행한 시도 횟수를 1만큼 증가시킨다.")
    void incrementTryCount() {
        // given
        int max = 1;
        ProgressManagement progressManagement = new ProgressManagement(max);

        // when
        progressManagement.incrementTryCount();

        // then
        assertThat(progressManagement.isProgress()).isFalse();
    }
}