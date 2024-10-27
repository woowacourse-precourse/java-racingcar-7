package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingCarService;
import racingcar.view.InstructionView;

public class RacingCarController {

    InstructionView instructionView;
    RacingCarService racingCarService;

    public RacingCarController(InstructionView instructionView, RacingCarService racingCarService) {
        this.instructionView = instructionView;
        this.racingCarService = racingCarService;
    }

    public void run() {

        instructionView.printInstruction("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        racingCarService.validateName(names);
        instructionView.printInstruction("시도할 횟수는 몇 회인가요?");
        String raceCount = Console.readLine();
        racingCarService.validateRaceCount(raceCount);

    }

}
