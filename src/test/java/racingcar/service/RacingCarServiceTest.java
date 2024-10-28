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
    @DisplayName("racingCarService의 기능을 테스트하기 위해 model을 적절한 값들로 초기화한다")
    void beforeEach(){
        this.racingCarModel = new RacingCarModel();
        ResultGeneratorService resultGeneratorService = new ResultGeneratorService();
        this.racingCarService = new RacingCarService(racingCarModel, resultGeneratorService);

        //given
        String carNameString = "pobi,woni,jun";

        //when
        racingCarModel.setCarNameList(carNameString);
        racingCarModel.setCarHashMap();
        racingCarService.setCarNameList();
    }


    @Test
    @DisplayName("경주의 결과가 정상적으로 출력되는지 확인한다")
    void getRacingResultTest(){
        //given & when
        racingCarModel.addRacingCar("woni", 1);
        racingCarModel.addRacingCar("jun", 2);

        String racingResult = racingCarService.getRacingResult();

        //then
        assertThat(racingResult).isEqualTo("pobi : \nwoni : -\njun : --");
    }


}
