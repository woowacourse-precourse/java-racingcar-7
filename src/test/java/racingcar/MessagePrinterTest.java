package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.MapBuilder.forwardCounter;
import static racingcar.MapBuilder.lineCounter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MessagePrinterTest {

    MessagePrinter messagePrinter = new MessagePrinter();
    MapBuilder mapBuilder = new MapBuilder();
    RandomPicker randomPicker = new RandomPicker();

    @ParameterizedTest
    @CsvSource({"'minitiated','최종 우승자 : minitiated'",
            "'tubi,po','최종 우승자 : tubi,po'",
            "'bora,tubi,po','최종 우승자 : bora,tubi,po'"})
    @DisplayName("List<String> winnerList의 구성원을 나열하면서 구분자로 쉼표를 써서 String 한 줄로 만들면 winnerMessage와 같다.")
    void testGetWinnerMessage(String stringToList, String winnerMessage) {

        List<String> winnerList = Arrays.asList(stringToList.split(","));
        String messageGet = messagePrinter.getWinnerMessage(winnerList);
        assertThat(messageGet).isEqualTo(winnerMessage);
    }

    @Test
    @DisplayName("List<String> winnerList가 null이면 IllegalArgumentException이 발생한다.")
    void testGetWinnerMessageNull() {
        List<String> winnerList = null;
        assertThatThrownBy(() -> messagePrinter.getWinnerMessage(winnerList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시행 1회의 결과 메시지는 carName1 : lineCount 후 줄바꿈 carName2 : lineCount 형식을 따른다.")
    void testGetSingleResultMessage() {
        forwardCounter = new TreeMap<>();
        lineCounter = new HashMap<>();
        List<String> carNames = Arrays.asList("bora", "tubi");
        int roundNum = 1;

        List<Map.Entry<String, String>> entry = mapBuilder.getSingleResult(carNames, roundNum);
        mapBuilder.mapInitForwardCount(carNames);
        mapBuilder.mapInitLineCount(carNames);
        randomPicker.runSingleRandom(carNames);
        String singleRoundResultMessage = messagePrinter.getSingleResultMessage(carNames, roundNum);

        List<String> possibleMessages = Arrays.asList("bora : -\ntubi : -", "bora : \ntubi : -",
                "bora : -\ntubi : ", "bora : \ntubi : ", "tubi : -\nbora : -", "tubi : \nbora : -",
                "tubi : -\nbora : ", "tubi : \nbora : ");
        assertThat(possibleMessages).contains(singleRoundResultMessage);
    }

    @Test
    @DisplayName("totalRoundResultList가 null이면 IllegalArgumentException이 발생한다.")
    void testGetTotalResultMessageNull() {
        List<String> totalRoundResultList = null;
        assertThatThrownBy(() -> messagePrinter.getTotalResultMessage(totalRoundResultList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
