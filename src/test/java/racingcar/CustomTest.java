package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import java.util.*;

public class CustomTest {

    @Test
    @DisplayName("자동차 이름 목록이 정상적으로 생성되는지 테스트")
    void testGetNames() {
        Map<String, Integer> race = new HashMap<>();
        String input = "pobi,woni,jun";
        Application.getNames(race, input);
        assertThat(race).containsKeys("pobi", "woni", "jun");
        assertThat(race.values()).allMatch(val -> val == 0);
    }
}
