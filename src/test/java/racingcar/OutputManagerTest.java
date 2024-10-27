package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class OutputManagerTest extends NsTest {

    @Test
    void 기능_테스트_단독우승() {
        List<String> testList = List.of("java");
        OutputManager.displayWinner(testList);

        assertThat(output()).isEqualTo("최종 우승자 : java");
    }

    @Test
    void 기능_테스트_공동우승() {
        List<String> testList = List.of("java", "pobi");
        OutputManager.displayWinner(testList);

        assertThat(output()).isEqualTo("최종 우승자 : java, pobi");
    }

    @Override
    protected void runMain() {
    }
}