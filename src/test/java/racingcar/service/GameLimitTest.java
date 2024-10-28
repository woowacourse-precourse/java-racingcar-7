package racingcar.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.util.Validator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLimitTest extends NsTest {

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName("자동차 개수 증가에 따른 성능 테스트")
    void carCountLimitTest() {
        run(generateCarNames(100), "1");

        String resultOutput = output();
        assertThat(resultOutput).contains("a99 : ");
    }

    @Test
    @DisplayName("게임 횟수 증가에 따른 성능 테스트")
    void roundCountLimitTest() {
        run("poby,woni,jun", "500");

        String resultOutput = output();
        assertThat(resultOutput).contains("최종 우승자 : ");
    }

    @Test
    @DisplayName("자동차 개수와 게임 횟수의 조합에 따른 테스트")
    void carAndRoundCombinationTest() {
        run(generateCarNames(50), "100");

        String resultOutput = output();
        assertThat(resultOutput).contains("최종 우승자 : ");
    }

    @Test
    @DisplayName("자동차 이름이 99개일 때 정상 작동")
    public void testCarNamesJustBelowMaxLimit() {
        List<String> carNames = Validator.validateCarNames(generateCarNames(99));
        assertEquals(99, carNames.size());
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
        return carNames.substring(0, carNames.length() - 1);
    }
}
