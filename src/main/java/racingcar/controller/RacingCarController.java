package racingcar.controller;

import racingcar.view.InstructionView;

public class RacingCarController {

    InstructionView instructionView;

    public RacingCarController() {
        instructionView = new InstructionView();

    }


    public void run() {
        instructionView.printInstruction("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        instructionView.printInstruction("시도할 횟수는 몇 회인가요?");
    }

}
