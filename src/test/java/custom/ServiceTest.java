package custom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import custom.service.CarNameParser;
import custom.service.GetAttemptCount;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ServiceTest {
    private final CarNameParser carNameParser = new CarNameParser();
    private final GetAttemptCount getAttemptCount = new GetAttemptCount();

    // 자동차 이름 분리 기능 테스트

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
        String input = "pobi,woni,jun";
        List<String> result = carNameParser.splitByComma(input);
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 자동차이름분리기능_앞뒤공백제거메소드_단일공백_테스트() {
        List<String> input = Arrays.asList(" pobi ", " woni ", " jun ");
        List<String> result = carNameParser.trimCarNames(input);
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 자동차이름분리기능_앞뒤공백제거메소드_연속공백_테스트() {
        List<String> input = Arrays.asList("  pobi  ", "  woni  ", "   jun   ");
        List<String> result = carNameParser.trimCarNames(input);
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 자동차이름분리기능_입력이NULL일때_테스트() {
        assertThatThrownBy(() -> carNameParser.run(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 null 일 수 없습니다");
    }

    @Test
    void 자동차이름분리기능_입력이빈문자열일때_테스트() {
        assertThatThrownBy(() -> carNameParser.run(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 빈 문자열 일 수 없습니다");
    }

    @Test
    void 자동차이름분리기능_입력이공백으로구성되어있을때_테스트() {
        assertThatThrownBy(() -> carNameParser.run("     "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 공백으로만 구성될 수 없습니다");
    }

    @Test
    void 자동차이름분리기능_입력이공백과쉼표로구성되어있을때_테스트() {
        assertThatThrownBy(() -> carNameParser.run(",   ,   ,, , ,, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 이루어지지 않았습니다");
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

    // 실행 횟수 변환 기능 테스트

    @Test
    void 실행횟수변환기능_입력이NULL일때_테스트() {
        assertThatThrownBy(() -> getAttemptCount.run(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 null 일 수 없습니다");
    }

    @Test
    void 실행횟수변환기능_입력이빈문자열일때_테스트() {
        assertThatThrownBy(() -> getAttemptCount.run(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 빈 문자열 일 수 없습니다");
    }

    @Test
    void 실행횟수변환기능_입력이공백으로구성되어있을때_테스트() {
        assertThatThrownBy(() -> getAttemptCount.run("    "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 공백으로만 구성될 수 없습니다");
    }

    @Test
    void 실행횟수변환기능_실행횟수문자열이숫자가아닐때_테스트() {
        assertThatThrownBy(() -> getAttemptCount.run("xyz"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 횟수는 숫자를 입력해야합니다");
    }

    @Test
    void 실행횟수변환기능_실행횟수가int타입의범위를초과할때_테스트() {
        assertThatThrownBy(() -> getAttemptCount.run("2147483648")) // Integer.MAX_VALUE + 1
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 횟수가 int 타입의 범위를 초과합니다");
    }

    @Test
    void 실행횟수변환기능_실행횟수가1회미만일때_테스트() {
        assertThatThrownBy(() -> getAttemptCount.run("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 횟수는 1회 이상이여야 합니다");
    }

    @Test
    void 실행횟수변환기능_통과_테스트() {
        int result = getAttemptCount.run("3");
        assertThat(result).isEqualTo(3);
    }
}
