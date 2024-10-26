package racingcar.input.car.trial;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.car.trial.MoveTrialValidator;

public class ConsoleMoveTrialInput implements MoveTrialInputHandler{

    private final MoveTrialValidator moveTrialValidator;

    public ConsoleMoveTrialInput(MoveTrialValidator moveTrialValidator) {
        this.moveTrialValidator = moveTrialValidator;
    }

    @Override
    public int readMoveTrialCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String trialCount = Console.readLine();
        moveTrialValidator.valdate(trialCount);
        return Integer.parseInt(trialCount);
    }
}
