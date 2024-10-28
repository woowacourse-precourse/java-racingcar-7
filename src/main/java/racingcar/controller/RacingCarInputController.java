package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InstructionView;

public class RacingCarInputController {

    InstructionView instructionView;

    public RacingCarInputController(InstructionView instructionView) {
        this.instructionView = instructionView;
    }

    public String getRacingCarNames() {
        instructionView.printInstruction("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String getRacingCarRaceCount() {
        instructionView.printInstruction("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}
