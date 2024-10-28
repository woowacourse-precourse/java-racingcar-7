package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.MapBuilder.forwardCounter;
import static racingcar.MapBuilder.lineCounter;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MapBuilderTest {

    @Test
    @DisplayName("List<String> carNames가 null이면 IllegalArgumentException이 발생한다.")
    void testCarNamesToCounts() {
        List<String> carNames = null;
        assertThatThrownBy(() -> MapBuilder.mapCarNamesToForwardCounts(carNames))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> MapBuilder.mapCarNamesToStringForwardLines(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"bora,tubi,nana,po",
                "bora,tubi,nana",
                "bora,tubi"})
    @DisplayName("carName 리스트의 사이즈는 forwardCounter 맵의 key 수와 같다.")
    void testMapCarNamesToForwardCounts(String carNames) {
        List<String> carNameList = List.of(carNames.split(","));
        MapBuilder.mapCarNamesToForwardCounts(carNameList);
        assertThat(forwardCounter.size()).isEqualTo(carNameList.size());
    }

    @ParameterizedTest
    @CsvSource({"bora,tubi,nana,po",
            "bora,tubi,nana",
            "bora,tubi"})
    @DisplayName("carName 리스트의 사이즈는 lineCounter 맵의 key 수와 같다.")
    void testMapCarNamesToStringForwardLines(String carNames) {
        List<String> carNameList = List.of(carNames.split(","));
        MapBuilder.mapCarNamesToStringForwardLines(carNameList);
        assertThat(lineCounter.size()).isEqualTo(carNameList.size());
    }

    @Test
    @DisplayName("1회 전진 처리 후; forwardCount와, forwardLine 내 '-'의 개수는 같다.")
    void testMapSingleCarForwardResult() {

        forwardCounter.put("tubi", 0);
        lineCounter.put("tubi", "");

        MapBuilder.mapSingleCarForwardResult("tubi");

        // forwardCounter의 값과 lineCounter 문자열 내 '-' 개수 일치 여부 검증
        int forwardCount = forwardCounter.get("tubi");
        String line = lineCounter.get("tubi");
        int lineCount = (int) line.chars().filter(hypen -> hypen == '-').count();

        assertThat(forwardCount).isEqualTo(lineCount);
    }

    @Test
    @DisplayName("forwardCount나 forwardLine이 null이면 IllegalArgumentException이 발생한다.")
    void testMapSingleCarForwardResultNull() {
        forwardCounter.put("tubi", null);
        lineCounter.put("tubi", null);
        assertThatThrownBy(() -> MapBuilder.mapSingleCarForwardResult("tubi"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> MapBuilder.mapSingleCarForwardResult("tubi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("lineCounter가 null이면 IllegalArgumentException이 발생한다.")
    void testGetSingleRoundResult() {

        String carNames = "bora,tubi,nana,po";
        List<String> carNameList = List.of(carNames.split(","));
        lineCounter = null;

        assertThatThrownBy(() -> MapBuilder.getSingleRoundResult(carNameList, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("반환값이 null이면 IllegalArgumentException이 발생한다.")
    void testGetCarNameAndForwardCount() {

        forwardCounter = null;

        assertThatThrownBy(() -> MapBuilder.getCarNameAndForwardCount())
                .isInstanceOf(IllegalArgumentException.class);
    }


}
