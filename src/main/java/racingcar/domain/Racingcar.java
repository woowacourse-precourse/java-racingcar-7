package racingcar.domain;

import racingcar.utils.Utils;
import racingcar.validation.Validation;
import racingcar.view.OutputView;

public class Racingcar {
    private static final String RACINGCAR_STEP_STRING = "-";

    private String name;
    private int step;

    public Racingcar(String name) {
        Validation.validateRacingcarName(name);
        this.name = name;
    }

    public int getStep(){
        return step;
    }

    public String getName(){
        return name;
    }

    public boolean isWinner(int winningStep){
        return step == winningStep;
    }

    public void goFoward(){
        if(Utils.getRandomNumber() >= 4){
            step++;
        }
        printRacingcarStep();
    }

    private void printRacingcarStep(){
        OutputView.printRacingCarStepResultMessage(name, getStepString());
    }

    private String getStepString(){
        return Utils.repeatString(RACINGCAR_STEP_STRING, step);
    }
}

