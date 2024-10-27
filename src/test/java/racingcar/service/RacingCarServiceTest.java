package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCarModel;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarServiceTest {

    private RacingCarService racingCarService;
    private RacingCarModel racingCarModel;

    @BeforeEach
    void beforeEach(){
        racingCarModel = new RacingCarModel();
        racingCarModel.setCarNameList("pobi,jun,woni");
        racingCarModel.addRacingCar("pobi", 0);
        racingCarModel.addRacingCar("jun", 2);
        racingCarModel.addRacingCar("woni", 2);
        racingCarService = new RacingCarService(racingCarModel);
    }


    @Test
    @DisplayName("최종 우승자 정보를 담고 있는 문자열 생성이 정상적으로 작동하는지 확인한다")
    void winnerResultStringTest(){
        //when
        racingCarService.setWinnerResultString();
        String winnerResultString = racingCarService.getWinnerResultString();

        //then
        assertThat(winnerResultString).isEqualTo("jun, woni");
    }

    @Test
    @DisplayName("최종 우승자 정보를 담고 있는 문자열 생성이 정상적으로 작동하는지 확인한다")
    void winnerResultStringTest2(){
        //given
        racingCarModel.addRacingCar("jun", 3);

        //when
        racingCarService.setWinnerResultString();
        String winnerResultString = racingCarService.getWinnerResultString();

        //then
        assertThat(winnerResultString).isEqualTo("jun");
    }

    @Test
    @DisplayName("각 경기 결과 정보를 담고 있는 문자열 생성이 정상적으로 작동하는지 확인한다")
    void createRacingResultTest(){
        //given
        racingCarModel.addRacingCar("jun", 3);

        //when
        String racingResult = racingCarService.createRacingResult();

        //then
        assertThat(racingResult).isEqualTo("pobi : \njun : ---\nwoni : --");
    }





}
