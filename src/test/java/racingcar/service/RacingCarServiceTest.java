package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarServiceTest {

    private RacingCarService racingCarService;
    private RacingCarModel racingCarModel;

    @BeforeEach
    void beforeEach(){
        racingCarModel = new RacingCarModel();
        racingCarService = new RacingCarService(racingCarModel);
    }


    @Test
    @DisplayName("")
    void createRacingResultTest(){
        //given
        racingCarModel.addRacingCar("pobi", 0);
        racingCarModel.addRacingCar("jun", 1);
        racingCarModel.addRacingCar("woni", 2);


        //when
        String racingResult = racingCarService.createRacingResult();

        //then
        assertThat(racingResult).isEqualTo("pobi : \njun : -\nwoni : --\n");

    }

    @Test
    @DisplayName("")
    void createWinnerResultTest(){
        //given
        racingCarModel.addRacingCar("pobi", 0);
        racingCarModel.addRacingCar("jun", 1);
        racingCarModel.addRacingCar("woni", 2);

        //when
        String winnerResult = racingCarService.createWinnerResult();

        //then
        assertThat(winnerResult).isEqualTo("woni");
    }


    @Test
    @DisplayName("")
    void createWinnerResultTest2(){
        //given
        racingCarModel.addRacingCar("pobi", 1);
        racingCarModel.addRacingCar("jun", 2);
        racingCarModel.addRacingCar("woni", 2);

        //when
        String winnerResult = racingCarService.createWinnerResult();

        //then
        assertThat(winnerResult).isEqualTo("jun, woni");
    }

    @Test
    @DisplayName("")
    void createWinnerResultTest3(){
        //given
        racingCarModel.addRacingCar("pobi", 0);
        racingCarModel.addRacingCar("jun", 0);
        racingCarModel.addRacingCar("woni", 0);

        //when
        String winnerResult = racingCarService.createWinnerResult();

        //then
        assertThat(winnerResult).isEqualTo("pobi, jun, woni");
    }


}
