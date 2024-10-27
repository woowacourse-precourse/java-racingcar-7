package racingcar.converter;

import racingcar.dto.GameOverDTO;
import racingcar.dto.carRoundResultDTO;
import racingcar.dto.roundResultDTO;
import racingcar.model.CarRoundResult;
import racingcar.model.RacingGame;
import racingcar.model.RoundResult;

import java.util.ArrayList;
import java.util.List;

public class GameOverDTOConverter {
    public GameOverDTO toGameOverDTO(RacingGame game){
        List<RoundResult> roundResults = game.getRoundResults();
        List<String> winners = game.getWinners();

        List<roundResultDTO> roundResultDTOS = new ArrayList<>();

        for(RoundResult roundResult : roundResults){
            List<CarRoundResult> carRoundResults = roundResult.getCarRoundResults();

            List<carRoundResultDTO> carRoundResultDTOS = new ArrayList<>();

            for(CarRoundResult carRoundResult : carRoundResults){
                carRoundResultDTO dto = new carRoundResultDTO(
                        carRoundResult.getCarName(),
                        carRoundResult.getCurrentCount()
                );
                carRoundResultDTOS.add(dto);
            }
            roundResultDTOS.add(new roundResultDTO(carRoundResultDTOS));
        }

        return new GameOverDTO(roundResultDTOS, winners);
    }
}
