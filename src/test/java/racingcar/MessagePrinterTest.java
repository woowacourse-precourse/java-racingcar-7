package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MessagePrinterTest {

    MessagePrinter messagePrinter = new MessagePrinter();

    @ParameterizedTest
    @CsvSource({"'minitiated','최종 우승자 : minitiated'",
                "'tubi,po','최종 우승자 : tubi,po'",
                "'bora,tubi,po','최종 우승자 : bora,tubi,po'"})
    @DisplayName("List")
    void testGetWinnerMessage(String stringToList, String winnerMessage) {

        List<String> winnerList = Arrays.asList(stringToList.split(","));
        String messageGet = messagePrinter.getWinnerMessage(winnerList);
        assertThat(messageGet).isEqualTo(winnerMessage);
    }
}
