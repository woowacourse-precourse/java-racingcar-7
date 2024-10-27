package racingcar.model;

import racingcar.utils.Utils;
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
            startOneRound();
            OutputView.printRacingGameRoundEndBlankLine();
        }
    }

    private void startOneRound(){
        racingcars.getRacingcars().stream()
                .forEach(Racingcar::goForward);
    }

    public void printWinner(){
        OutputView.printRacingGameWinner(getWinner());
    }

    private List<String> getWinner(){
        return racingcars.getRacingcars().stream()
                .filter(racingcar -> racingcar.isWinner(getWinningStep()))
                .map(Racingcar::getName)
                .collect(Collectors.toList());
    }

    private int getWinningStep(){
        return Utils.getMaxValue(getSteps());
    }

    private List<Integer> getSteps(){
        return racingcars.getRacingcars().stream()
                .map(Racingcar::getStep)
                .collect(Collectors.toList());
    }

}
