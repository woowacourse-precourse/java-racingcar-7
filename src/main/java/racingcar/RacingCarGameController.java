package racingcar;

import racingcar.dto.RacingGameInitializationRequest;

public class RacingCarGameController {
    RacingCarGameView racingCarGameView = new RacingCarGameView();
    RacingCarGameModel racingCarGameModel = new RacingCarGameModel();

    public void startGame() {
        RacingGameInitializationRequest racingGameInitializationRequest = racingCarGameView.gameInit();
        racingCarGameModel.initializationGame(racingGameInitializationRequest);

        String racingResult = racingCarGameModel.startGame();
        String winnerParticipants = racingCarGameModel.winnerParticipants();
        racingCarGameView.racingGameCurrentSituationPrint(racingResult, winnerParticipants);
    }
}
