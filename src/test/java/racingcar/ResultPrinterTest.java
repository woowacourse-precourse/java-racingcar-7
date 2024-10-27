package racingcar;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultPrinterTest {

    @Test
    void 공동우승자_찾기_테스트() {
        // 테스트 데이터 생성
        Car[] cars = {new Car("pobi"), new Car("woni"), new Car("sh")};
        cars[0].dashCount = 3; // pobi
        cars[1].dashCount = 7; // woni
        cars[2].dashCount = 7; // sh

        // 우승자 찾기 메소드 호출
        List<String> winners = ResultPrinter.findWinner(cars);

        // 결과 검증
        List<String> expectedWinners = List.of("woni", "sh");
        assertThat(winners).isEqualTo(expectedWinners);
    }
}
