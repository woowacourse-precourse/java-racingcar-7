package view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceViewTest extends NsTest {

    @Test
    void 출력_포맷_확인() {
        //given
        LinkedHashMap<String, Integer> carProgress = new LinkedHashMap<>();
        carProgress.put("pobi", 4);
        assertSimpleTest(() -> {
            RaceView.view(carProgress);
            assertThat(output()).contains("pobi : ----");
        });
    }

    @Test
    void 출력_순서_확인() {
        //given
        LinkedHashMap<String, Integer> carProgress = new LinkedHashMap<>();
        carProgress.put("pobi", 1);
        carProgress.put("woni", 3);
        carProgress.put("jun", 2);
        assertSimpleTest(() -> {
            RaceView.view(carProgress);
            List<String> expected = List.of("pobi : -", "woni : ---", "jun : --");
            List<String> output = Arrays.asList(output().split("\\r?\\n"));
            assertThat(output).containsExactlyElementsOf(expected);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}