package racingcar.controller;

import racingcar.domain.Race;
import racingcar.util.PlayerParser;
import racingcar.util.RoundParser;
import racingcar.view.RacingCarView;

public class RacingCarController {
    private String[] players;
    private int rounds;

    public RacingCarController() {
        this.players = PlayerParser.parse(RacingCarView.inputPlayer());
        this.rounds = RoundParser.parse(RacingCarView.inputRound());
    }

    public void runRacingCar() {
        RacingCarView.printGame();
        Race race = new Race(players);
        for (int i = 0; i < rounds; i++) {
            RacingCarView.printRoundResult(race.runRound());
        }
    }
}
