package racingcar.model;

import racingcar.utils.Utils;
import racingcar.validation.Validation;
import racingcar.view.OutputView;

public class Racingcar {
    private static final String RACINGCAR_STEP_STRING = "-";
    private static final int MOVING_FORWARD = 4;

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

    public void goForward(){
        if(Utils.getRandomNumber() >= MOVING_FORWARD){
            step++;
        }
        showRacingcarStep();
    }

    private void showRacingcarStep(){
        OutputView.printRacingCarStepResultMessage(name, getStepString());
    }

    private String getStepString(){
        return Utils.repeatString(RACINGCAR_STEP_STRING, step);
    }
}

