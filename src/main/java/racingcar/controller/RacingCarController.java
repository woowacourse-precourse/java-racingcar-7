package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingCarService;
import racingcar.service.ValidateService;
import racingcar.view.InstructionView;


public class RacingCarController {

    InstructionView instructionView;
    ValidateService validateService;
    RacingCarService racingCarService;

    public RacingCarController(InstructionView instructionView, ValidateService validateService, RacingCarService racingCarService) {
        this.instructionView = instructionView;
        this.validateService = validateService;
        this.racingCarService = racingCarService;
    }

    public void run() {
        instructionView.printInstruction("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        validateService.validateName(names);
        instructionView.printInstruction("시도할 횟수는 몇 회인가요?");
        String raceCount = Console.readLine();
        validateService.validateRaceCount(raceCount);

        racingCarService.setupRaceCars(validateService.getValidatedNames());

        racingCarService.runRound();

    }

}
