package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputManagerTest extends NsTest {

    @Test
    @DisplayName("리스트에 이름이 1개일 경우, 단독 우승으로 쉼표로 구분없이 결과 출력")
    void 기능_테스트_단독우승() {
        List<String> testWinnerList = List.of("java");
        OutputManager.displayWinner(testWinnerList);

        assertThat(output()).isEqualTo("최종 우승자 : java");
    }

    @Test
    @DisplayName("리스트에 이름 여러 개일 경우, 공동 우승으로 쉼표로 구분하여 결과 출력")
    void 기능_테스트_공동우승() {
        List<String> testWinnerList = List.of("java", "pobi");
        OutputManager.displayWinner(testWinnerList);

        assertThat(output()).isEqualTo("최종 우승자 : java, pobi");
    }

    @Override
    protected void runMain() {
    }
}