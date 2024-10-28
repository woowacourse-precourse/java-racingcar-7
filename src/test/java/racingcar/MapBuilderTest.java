package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.MapBuilder.forwardCounter;
import static racingcar.MapBuilder.lineCounter;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MapBuilderTest {

    MapBuilder mapBuilder = new MapBuilder();

    @Test
    @DisplayName("List<String> carNames가 null이면 IllegalArgumentException이 발생한다.")
    void testCarNamesToCounts() {
        List<String> carNames = null;
        assertThatThrownBy(() -> mapBuilder.mapInitForwardCount(carNames))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> mapBuilder.mapInitLineCount(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"bora,tubi,nana,po",
            "bora,tubi,nana",
            "bora,tubi"})
    @DisplayName("carName 리스트의 사이즈는 forwardCounter 맵의 key 수와 같다.")
    void testMapInitForwardCount(String carNames) {
        forwardCounter = new TreeMap<>();
        List<String> carNameList = List.of(carNames.split(","));
        mapBuilder.mapInitForwardCount(carNameList);
        assertThat(forwardCounter.size()).isEqualTo(carNameList.size());
    }

    @ParameterizedTest
    @CsvSource({"bora,tubi,nana,po",
            "bora,tubi,nana",
            "bora,tubi"})
    @DisplayName("carName 리스트의 사이즈는 lineCounter 맵의 key 수와 같다.")
    void testMapInitLineCount(String carNames) {
        lineCounter = new HashMap<>();
        List<String> carNameList = List.of(carNames.split(","));
        mapBuilder.mapInitLineCount(carNameList);
        assertThat(lineCounter.size()).isEqualTo(carNameList.size());
    }

    @Test
    @DisplayName("1회 전진 처리 후; forwardCount와, forwardLine 내 '-'의 개수는 같다.")
    void testMapSingleResult() {
        forwardCounter.put("tubi", 0);
        lineCounter.put("tubi", "");
        mapBuilder.mapSingleResult("tubi");

        // forwardCounter의 값과 lineCounter 문자열 내 '-' 개수 일치 여부 검증
        int forwardCount = forwardCounter.get("tubi");
        String line = lineCounter.get("tubi");
        int lineCount = (int) line.chars().filter(hypen -> hypen == '-').count();
        assertThat(forwardCount).isEqualTo(lineCount);
    }

    @Test
    @DisplayName("forwardCount나 forwardLine이 null이면 IllegalArgumentException이 발생한다.")
    void testMapSingleResultNull() {
        forwardCounter.put("tubi", null);
        lineCounter.put("tubi", null);
        assertThatThrownBy(() -> mapBuilder.mapSingleResult("tubi"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> mapBuilder.mapSingleResult("tubi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("lineCounter가 null이면 IllegalArgumentException이 발생한다.")
    void testGetSingleResult() {
        String carNames = "bora,tubi,nana,po";
        List<String> carNameList = List.of(carNames.split(","));
        if (lineCounter == null) {
        assertThatThrownBy(() -> mapBuilder.getSingleResult(carNameList, 1))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("반환값이 null이면 IllegalArgumentException이 발생한다.")
    void testGetForwardCount() {
        forwardCounter = null;
        assertThatThrownBy(() -> mapBuilder.getForwardCount())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
