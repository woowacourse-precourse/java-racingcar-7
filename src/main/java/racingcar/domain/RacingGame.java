package racingcar.domain;

import racingcar.validation.Validation;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Racingcar> racingcars;

    public RacingGame(List<String> racingcarNames) {
        Validation.validateRacingcarNames(racingcarNames);
        this.racingcars = createRacingcars(racingcarNames);
    }

    private List<Racingcar> createRacingcars(List<String> racingcarNames){
        return racingcarNames.stream()
                .map(Racingcar::new)
                .collect(Collectors.toList());
    }

    public void startRacingGame(int racingCount){
        Validation.validateRacingGameCount(racingCount);
        OutputView.printRacingGameExecuteResultMessage();
        for(int i = 0;  i < racingCount; i++){
            startGameRound();
            OutputView.printRacingGameRoundEndBlankLine();
        }
    }

    private void startGameRound(){
        racingcars.stream()
                .forEach(Racingcar::goFoward);
    }

}
