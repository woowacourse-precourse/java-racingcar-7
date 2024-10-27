package racingcar.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class GameLimitTest extends NsTest {

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName("자동차 개수 증가에 따른 성능 테스트")
    void carCountLimitTest() {
        run(generateCarNames(100), "1");  // 자동차 100대, 라운드 1번

        String resultOutput = output();
        assertThat(resultOutput).contains("a99 : ");  // 마지막 자동차 이름 확인 (poby99)
        // 필요시 성능 테스트 추가
    }

    @Test
    @DisplayName("게임 횟수 증가에 따른 성능 테스트")
    void roundCountLimitTest() {
        run("poby,woni,jun", "500");  // 자동차 3대, 500 라운드

        String resultOutput = output();
        assertThat(resultOutput).contains("최종 우승자 : "); // 최종 우승자 확인
        // 필요시 성능 테스트 추가
    }

    @Test
    @DisplayName("자동차 개수와 게임 횟수의 조합에 따른 테스트")
    void carAndRoundCombinationTest() {
        run(generateCarNames(50), "100");  // 자동차 50대, 100 라운드

        String resultOutput = output();
        assertThat(resultOutput).contains("최종 우승자 : "); // 우승자 확인
        // 필요시 성능 테스트 추가
    }

    @Test
    @DisplayName("자동차 개수 초과 시 예외 발생")
    void carCountExceedsLimitTest() {
        assertThatThrownBy(() -> run(generateCarNames(101), "1"))  // 101대로 제한 초과
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 개수는 100대를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("라운드 횟수 초과 시 예외 발생")
    void roundCountExceedsLimitTest() {
        assertThatThrownBy(() -> run("poby,woni,jun", "501"))  // 501번으로 제한 초과
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드 횟수는 500회를 초과할 수 없습니다.");
    }

    // 자동차 이름 생성 도우미 메서드
    private String generateCarNames(int count) {
        StringBuilder carNames = new StringBuilder();
        for (int i = 0; i < count; i++) {
            carNames.append("a").append(i).append(",");
        }
        return carNames.substring(0, carNames.length() - 1); // 마지막 쉼표 제거
    }
}
