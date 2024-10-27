package racingcar;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import view.ViewScreen;

public class ViewScreenTest {
    static final ViewScreen viewScreen = new ViewScreen();
    
    @ParameterizedTest
    @CsvSource({"pobi,0,pobi :", "woni,2,woni : --", "a,5,a : -----"})
    void 자동차_하나의_경주_상황_출력(String name, String strDistance, String expectedOutput) {
        int intDistance = parseInt(strDistance);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        viewScreen.printRace(name, intDistance);
        assertEquals(expectedOutput, outputStream.toString().trim());
        System.setOut(originalOut);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi;최종 우승자 : pobi", "pobi,woni,elly;최종 우승자 : pobi, woni, elly",
            "pobi,woni,elly,a,b,c,d;최종 우승자 : pobi, woni, elly, a, b, c, d"}, delimiter = ';')
    void 우승자_출력(String namesString, String expectedOutput) {
        List<String> nameList = Arrays.asList(namesString.split(","));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        viewScreen.printWinner(nameList);
        assertEquals(expectedOutput, outputStream.toString().trim());
        System.setOut(originalOut);
    }

    @ParameterizedTest
    @CsvSource({"123,123", "sds,sds", "'\n','\n'"})
    void 커스텀_출력_테스트(String customPrint, String expectedOutput) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        viewScreen.customPrint(customPrint);
        assertEquals(expectedOutput, outputStream.toString());
        System.setOut(originalOut);
    }
}
