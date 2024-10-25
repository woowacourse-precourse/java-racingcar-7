package racingcar.domain;

import racingcar.utils.Utils;
import racingcar.validation.Validation;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private Racingcars racingcars;
    private GameRound gameRound;

    public RacingGame(Racingcars racingcars, GameRound gameRound) {
        this.racingcars = racingcars;
        this.gameRound = gameRound;
    }

    public void startRacingGame(){
        OutputView.printRacingGameExecuteResultMessage();

        for(int i = 0;  i < gameRound.getRoundCount(); i++){
            startGameRound();
            OutputView.printRacingGameRoundEndBlankLine();
        }
    }

    private void startGameRound(){
        racingcars.getRacingcars().stream()
                .forEach(Racingcar::goFoward);
    }

    public void printWinner(){
        OutputView.printRacingGameWinner(getWinner());
    }

    public List<String> getWinner(){
        return racingcars.getRacingcars().stream()
                .filter(racingcar -> racingcar.isWinner(getWinningStep()))
                .map(Racingcar::getName)
                .collect(Collectors.toList());
    }

    public int getWinningStep(){
        List<Integer> steps = racingcars.getRacingcars().stream()
                .map(Racingcar::getStep)
                .collect(Collectors.toList());
        return Utils.getMaxValue(steps);
    }

}
