package racingcar.viewHandler;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApiHandlerTest {

    private final ApiHandler apiHandler = ApiHandler.of();

    @Test
    void 차_이름_분리() {
        String inputData = "pobi,woni,jun";
        List<String> expect = List.of("pobi", "woni", "jun");
        List<String> result = apiHandler.splitCarnames(inputData);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 총_게임_라운드() {
        String inputData = "5";
        Integer expect = 5;
        Integer result = apiHandler.parserTotalRound(inputData);
        assertThat(result).isEqualTo(expect);
    }

}