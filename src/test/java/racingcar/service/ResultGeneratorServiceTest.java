package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultGeneratorServiceTest {
    private final ResultGeneratorService resultGeneratorService= new ResultGeneratorService();


    @Test
    @DisplayName("각 자동차의 경주 결과를 올바른 형식으로 출력하는지 확인한다")
    void generateRacingResultTest(){
        //given
        String carName = "pobi";
        int forwardCount = 3;

        //when
        String racingResult = resultGeneratorService.generateRacingResult(carName, forwardCount);

        //then
        assertThat(racingResult).isEqualTo("pobi : ---");
    }


    @Test
    @DisplayName("최종 우승자를 올바른 형식으로 출력하는지 확인한다")
    void generateWinnerResultTest(){
        //given
        List<String> winnerList = Arrays.asList("pobi", "woni");

        //when
        String winnerResult = resultGeneratorService.generateWinnerResult(winnerList);

        //then
        assertThat(winnerResult).isEqualTo("pobi, woni");
    }



}
