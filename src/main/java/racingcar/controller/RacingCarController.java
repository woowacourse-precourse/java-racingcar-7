package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingCar;
import racingcar.service.RacingCarService;
import racingcar.service.ValidateService;
import racingcar.view.InstructionView;
import racingcar.view.RoundView;

import java.util.stream.IntStream;


public class RacingCarController {

    InstructionView instructionView;
    ValidateService validateService;
    RacingCarService racingCarService;
    RoundView roundView;

    public RacingCarController(InstructionView instructionView, ValidateService validateService, RacingCarService racingCarService, RoundView roundView) {
        this.instructionView = instructionView;
        this.validateService = validateService;
        this.racingCarService = racingCarService;
        this.roundView = roundView;
    }

    public void run() {
        instructionView.printInstruction("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        validateService.validateName(names);
        instructionView.printInstruction("시도할 횟수는 몇 회인가요?");
        String raceCount = Console.readLine();
        validateService.validateRaceCount(raceCount);

        racingCarService.setupRaceCars(validateService.getValidatedNames());

        roundView.setRacingCars(racingCarService.getRacingCars());

        IntStream.range(0, (int) validateService.getValidateRaceCount()).forEach(round -> {
            racingCarService.getRacingCars().forEach(RacingCar::move);
            roundView.showRoundResults();
        });

    }

}
