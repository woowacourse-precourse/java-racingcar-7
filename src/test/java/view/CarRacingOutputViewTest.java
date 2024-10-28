package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarRacing;
import racingcar.domain.RacingCarPolicy;
import racingcar.dto.RacingOutputDTO;
import racingcar.dto.ValidatedInputDataDTO;
import racingcar.infrastructure.RacingCarHistory;
import racingcar.presentation.RacingCarOutputView;

class CarRacingOutputViewTest {
    @DisplayName("레이스 최종결과를 출력한다.")
    @Test
    void printRacingResult() {
        //given
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,toto,lala", 10L);
        CarRacing racing = new CarRacing(validatedInputDataDTO,new RacingCarPolicy(), new RacingCarHistory());
        racing.generateRacer(validatedInputDataDTO.name().split(","));
        //when

        RacingOutputDTO racingOutputDTO = racing.racingStart();

        RacingCarOutputView racingCarOutputView = new RacingCarOutputView(racingOutputDTO);
        racingCarOutputView.printRacingResult();

        //then

    }

}