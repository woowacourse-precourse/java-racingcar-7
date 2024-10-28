package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InstructionView;

import static racingcar.util.PromptMessage.*;

public class RacingCarInputController {

    InstructionView instructionView;

    public RacingCarInputController(InstructionView instructionView) {
        this.instructionView = instructionView;
    }

    public String getRacingCarNames() {
        instructionView.printInstruction(PROMPT_CAR_NAMES);
        return Console.readLine();
    }

    public String getRacingCarRaceCount() {
        instructionView.printInstruction(PROMPT_RACE_COUNT);
        return Console.readLine();
    }
}
