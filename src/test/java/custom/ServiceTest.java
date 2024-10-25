package custom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import custom.service.CarNameParser;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ServiceTest {
    private final CarNameParser carNameParser = new CarNameParser();

    @Test
    void 자동차이름분리기능_쉼표정리메소드_연속된쉼표제거_테스트() {
        String input = "pobi,,,woni,,,javaji";
        String result = carNameParser.cleanComma(input);
        assertThat(result).isEqualTo("pobi,woni,javaji");
    }

    @Test
    void 자동차이름분리기능_쉼표정리메소드_앞뒤단일쉼표제거_테스트() {
        String input = ",pobi,woni,";
        String result = carNameParser.cleanComma(input);
        assertThat(result).isEqualTo("pobi,woni");
    }

    @Test
    void 자동차이름분리기능_쉼표정리메소드_앞뒤연속된쉼표제거_테스트() {
        String input = ",,,pobi,woni,,,";
        String result = carNameParser.cleanComma(input);
        assertThat(result).isEqualTo("pobi,woni");
    }

    @Test
    void 자동차이름분리기능_문자열분리메소드_테스트() {
        String input = "pobi,woni,javaji";
        List<String> result = carNameParser.splitByComma(input);
        assertThat(result).containsExactly("pobi", "woni", "javaji");
    }

    @Test
    void 자동차이름분리기능_공백제거메소드_단일공백_테스트() {
        List<String> input = Arrays.asList(" pobi ", " woni ", " javaji ");
        List<String> result = carNameParser.trimCarNames(input);
        assertThat(result).containsExactly("pobi", "woni", "javaji");
    }

    @Test
    void 자동차이름분리기능_공백제거메소드_연속공백_테스트() {
        List<String> input = Arrays.asList("  pobi  ", "  woni  ", "   javaji   ");
        List<String> result = carNameParser.trimCarNames(input);
        assertThat(result).containsExactly("pobi", "woni", "javaji");
    }

    @Test
    void 자동차이름분리기능_입력된문자열이빈문자열일때_테스트() {
        assertThatThrownBy(() -> carNameParser.run(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 빈 문자열 일 수 없습니다");
    }

    @Test
    void 자동차이름분리기능_입력된자동차가2대미만일때_테스트() {
        assertThatThrownBy(() -> carNameParser.run("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차가 2대 미만 입력되었습니다");
    }

    @Test
    void 자동차이름분리기능_자동차이름이5자초과일때_테스트() {
        assertThatThrownBy(() -> carNameParser.run("pobi, woni, longCarName"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 중 5자를 초과하는 이름이 있습니다");
    }

    @Test
    void 자동차이름분리기능_자동차이름이중복될때_테스트() {
        assertThatThrownBy(() -> carNameParser.run("pobi, woni, pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 중 중복된 이름이 있습니다");
    }

    @Test
    void 자동차이름분리기능_자동차이름에공백이있을때_테스트() {
        assertThatThrownBy(() -> carNameParser.run("pobi, ju n"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 중 공백이 포함된 이름이 있습니다");
    }

    @Test
    void 자동차이름분리기능_자동차이름이알파벳이나한글이아닐때_테스트() {
        assertThatThrownBy(() -> carNameParser.run("pobi, 123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차량 이름은 알파벳이나 한글로 작성되어야 합니다.");
    }

    @Test
    void 자동차이름분리기능_통과_테스트() {
        String input = "pobi, woni, jun";
        List<String> result = carNameParser.run(input);
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }
}
