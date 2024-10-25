package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomStringUtilsTest {

    @DisplayName("문자열 출력 테스트")
    @Test
    void printStringLineFeed() {
        //given
        String str = "print";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        //when
        CustomStringUtils.printStringLineFeed(str);

        //then
        assertThat(outputStream.toString()).isEqualTo(str.concat("\n"));

        //원래의 System.out으로 변경
        System.setOut(originalOut);
    }

    @DisplayName("최종 우승자 출력 테스트")
    @Test
    void printWinners() {
        //given
        List<String> winners = List.of("pobi", "woni", "jun");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        //when
        CustomStringUtils.printFinalWinners(winners);

        //then
        assertThat(outputStream.toString()).isEqualTo("최종 우승자 : pobi, woni, jun\n");

        //원래의 System.out으로 변경
        System.setOut(originalOut);
    }
}