package racingcar.domain;

import racingcar.utils.Utils;
import racingcar.validation.Validation;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Racingcar> racingcars;
    private int racingGameCount;

    public RacingGame(List<Racingcar> racingcars, int racingGameCount) {
        Validation.validateRacingcarNamesDuplicate(racingcars);
        Validation.validateRacingGameCount(racingGameCount);
        this.racingcars = racingcars;
        this.racingGameCount = racingGameCount;
    }

    public static List<Racingcar> createRacingcars(List<String> racingcarNames){
        return racingcarNames.stream()
                .map(Racingcar::new)
                .collect(Collectors.toList());
    }

    public void startRacingGame(){
        OutputView.printRacingGameExecuteResultMessage();

        for(int i = 0;  i < racingGameCount; i++){
            startGameRound();
            OutputView.printRacingGameRoundEndBlankLine();
        }
    }

    private void startGameRound(){
        racingcars.stream()
                .forEach(Racingcar::goFoward);
    }

    public void printWinner(){
        OutputView.printRacingGameWinner(getWinner());
    }

    public List<String> getWinner(){
        return racingcars.stream()
                .filter(racingcar -> racingcar.isWinner(getWinningStep()))
                .map(Racingcar::getName)
                .collect(Collectors.toList());
    }

    public int getWinningStep(){
        List<Integer> steps = racingcars.stream()
                .map(Racingcar::getStep)
                .collect(Collectors.toList());
        return Utils.getMaxValue(steps);
    }

}
