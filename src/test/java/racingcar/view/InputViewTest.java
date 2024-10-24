package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @AfterEach
    void clean() {
        Console.close();
    }

    @DisplayName("자동차 이름을 입력받아 문자열 리스트를 반환한다.")
    @Test
    void readCarNames() {
        // given
        String input = "pobi,crong,honux\n";  // 사용자 입력 시뮬레이션
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        List<String> carNames = InputView.readCarNames();

        // then
        assertThat(carNames).containsExactly("pobi", "crong", "honux");
    }

    @DisplayName("이동횟수를 입력받아 Integer타입으로 반환한다.")
    @Test
    void readTotalRounds() {
        // given
        String input = "5\n";  // 사용자 입력 시뮬레이션
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Integer totalRounds = InputView.getTotalRounds();

        // then
        assertThat(totalRounds).isEqualTo(5);
        assertThat(totalRounds).isInstanceOf(Integer.class);
    }

}