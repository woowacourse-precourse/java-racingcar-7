package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RefereeTest {


    @Test
    void 라운드_입력이_Null인지_검사() {
        String round = null;

        Assertions.assertThatThrownBy(() -> {
                    new Referee(round);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null은 입력할 수 없습니다.");
    }

    @Test
    void 라운드_입력이_빈문자열인지_검사() {
        String round = "";

        Assertions.assertThatThrownBy(() -> {
                    new Referee(round);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라운드 입력은 숫자만 가능합니다.");
    }

    @Test
    void 라운드_입력이_공백인지_검사() {
        String round = " ";

        Assertions.assertThatThrownBy(() -> {
                    new Referee(round);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라운드 입력은 숫자만 가능합니다.");
    }

    @Test
    void 라운드_입력이_숫자가_아닌_문자열인지_검사() {
        String round = "문자열";

        Assertions.assertThatThrownBy(() -> {
                    new Referee(round);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라운드 입력은 숫자만 가능합니다.");
    }

    @Test
    void 단일_우승자_판단() {
        // give
        Referee referee = new Referee("3");

        Map<String, Integer> carsDecision = new LinkedHashMap<>();
        carsDecision.put("소정", 3);
        carsDecision.put("pobi", 2);
        carsDecision.put("woni", 1);

        List<String> expectedWinners = List.of("소정");

        // when
        List<String> actualWinner = referee.judgmentWinner(carsDecision);

        // then
        Assertions.assertThat(actualWinner).isEqualTo(expectedWinners);
    }

    @Test
    void 공동_우승자_판단() {
        // give
        Referee referee = new Referee("3");

        Map<String, Integer> carsDecision = new LinkedHashMap<>();
        carsDecision.put("소정", 3);
        carsDecision.put("pobi", 3);
        carsDecision.put("woni", 2);

        List<String> expectedWinners = List.of("소정", "pobi");

        // when
        List<String> actualWinner = referee.judgmentWinner(carsDecision);

        // then
        Assertions.assertThat(actualWinner).isEqualTo(expectedWinners);
    }
}
