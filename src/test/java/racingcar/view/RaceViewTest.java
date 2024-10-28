package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.Application;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceViewTest extends NsTest {

    @Test
    void 출력_포맷_확인() {
        //given
    @ParameterizedTest
    @DisplayName("진행 과정 출력 테스트")
    @MethodSource("provideRaceProgress")
    void displayProgress(Map<String, Integer> carProgress, List<String> result) {
        assertSimpleTest(() -> {
            RaceView.displayProgress(carProgress);
            assertThat(output()).contains(result);
        });
    }

    private static Stream<Arguments> provideRaceProgress() {
        return Stream.of(
                Arguments.of(
                        Map.of("pobi", 4),
                        List.of("pobi : ----")
                ),
                Arguments.of(
                        Map.of("pobi", 4, "jun", 3),
                        List.of("pobi : ----", "jun : ---")
                ),
                Arguments.of(
                        Map.of("pobi", 4, "jun", 3, "kaye", 0),
                        List.of("pobi : ----", "jun : ---", "kaye : ")
                )
        );
    }

    @ParameterizedTest
    @DisplayName("진행 과정 출력 예외 테스트")
    @NullAndEmptySource
    void displayProgress_X(LinkedHashMap<String, Integer> emptyProgress) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> RaceView.displayProgress(emptyProgress))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("진행 과정 출력 순서 테스트")
    void 출력_순서_확인() {
        //given
        LinkedHashMap<String, Integer> carProgress = new LinkedHashMap<>();
        carProgress.put("pobi", 1);
        carProgress.put("woni", 3);
        carProgress.put("jun", 2);
        assertSimpleTest(() -> {
            RaceView.displayProgress(carProgress);
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