package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MessagePrinterTest {

    MessagePrinter messagePrinter = new MessagePrinter();

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

}
