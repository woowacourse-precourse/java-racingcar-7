package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomMoveDistanceProviderTest {

    private final RandomMoveDistanceProvider provider = new RandomMoveDistanceProvider();

    @RepeatedTest(100)
    @DisplayName("랜덤 이동 거리 생성기가 0과 9 사이의 값을 반환하는지 테스트")
    void generateMoveDistance_범위_테스트() {
        int moveDistance = provider.generateMoveDistance();
        Assertions.assertThat(moveDistance).isBetween(0, 9); // 0 이상 9 이하 값인지 확인
    }
}