package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingCarDTO;

import static racingcar.view.OutputView.printEachDistanceByRandomMovement;

class OutputViewTest {

    @Test
    @DisplayName("DTO에 의한 출력 결과를 확인")
    void checkRoundResultPrint(){
        //given
        RacingCarDTO racingCarDTO = new RacingCarDTO("park", "1");
        racingCarDTO.updateRacingCarDistance("park", 10);

        printEachDistanceByRandomMovement(racingCarDTO);
    }

}