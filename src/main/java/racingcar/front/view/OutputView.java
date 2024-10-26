package racingcar.front.view;

import racingcar.global.dto.CarRaceResponseDTO;
import racingcar.front.builder.GamePhaseOutputBuilder;
import racingcar.front.builder.GameWinnerOutputBuilder;
import racingcar.front.view.message.OutputViewMessage;

public class OutputView {
    public void writeGameResult(CarRaceResponseDTO carRaceResponseDTO) {
        System.out.println("\n" +  OutputViewMessage.RACE_RESULT_MESSAGE.getMessage());
        System.out.print(GamePhaseOutputBuilder.build(carRaceResponseDTO));

        System.out.print(OutputViewMessage.WINNER_MESSAGE.getMessage());
        System.out.println(GameWinnerOutputBuilder.build(carRaceResponseDTO));
    }
}
