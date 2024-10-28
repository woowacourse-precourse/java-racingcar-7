package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTests {

    @Test
    @DisplayName("경주에 참가하는 명단의 이름이 1개뿐이면 경주를 진행하지 않고 예외 발생")
    void throwExceptionIfRacingCarOnlyOne() {
        List<String> racerNames = List.of("alice");
        assertThatThrownBy(() -> new Racing(racerNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경주에 참가하는 명단의 이름 중 하나라도 길이 제한을 충족하지 못하면 예외 발생")
    void throwExceptionIfAnyRacerNameLengthNotInRange() {
        List<String> racerNames = List.of("alice", "bob", "charlie");
        assertThatThrownBy(() -> new Racing(racerNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}