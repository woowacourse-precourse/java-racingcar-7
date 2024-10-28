package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.service.RacingCarService;
import racingcar.service.ValidateService;
import racingcar.util.RandomGenerator;
import racingcar.util.RandomsWrapper;
import racingcar.view.InstructionView;
import racingcar.view.ResultView;
import racingcar.view.RoundView;

import java.util.List;
import java.util.stream.IntStream;

public class MainController {

    private final RacingCarInputController racingCarInputController;
    private final RacingCarController racingCarController;
    private final RacingCarOutputController racingCarOutputController;
    private List<RacingCar> racingCars;

    public MainController() {
        InstructionView instructionView = new InstructionView();
        ValidateService validateService = new ValidateService();
        RacingCarService racingCarService = new RacingCarService();
        RoundView roundView = new RoundView();
        ResultView resultView = new ResultView();
        RandomGenerator randomGenerator = new RandomsWrapper();

        this.racingCarInputController = new RacingCarInputController(instructionView);
        this.racingCarController = new RacingCarController(validateService, racingCarService, randomGenerator);
        this.racingCarOutputController = new RacingCarOutputController(roundView, resultView);
    }

    public void run() {
        List<String> validatedNames = getValidatedNames();
        long validatedRaceCount = getValidatedRaceCount();
        setupRacingCars(validatedNames);
        runRaceRounds(validatedRaceCount);
        printRaceResults();
    }

    // 이름 입력 및 유효성 검증
    private List<String> getValidatedNames() {
        String names = racingCarInputController.getRacingCarNames();
        return racingCarController.validateName(names);
    }

    // 경주 횟수 입력 및 유효성 검증
    private long getValidatedRaceCount() {
        String raceCount = racingCarInputController.getRacingCarRaceCount();
        return racingCarController.validateRaceCount(raceCount);
    }

    // 경주 차 초기화
    private void setupRacingCars(List<String> validatedNames) {
        this.racingCars = racingCarController.setupRacingCars(validatedNames);
    }

    // 경주 진행
    private void runRaceRounds(long validatedRaceCount) {
        racingCarOutputController.startRaceRound();
        IntStream.range(0, (int) validatedRaceCount)
                .forEach(i -> {
                    racingCarController.runRaceRound(racingCars);
                    racingCarOutputController.showRaceRound(racingCars);
                });
    }

    // 경주 결과 출력
    private void printRaceResults() {
        List<RacingCar> bestDrivers = racingCarController.findBestDriver(racingCars);
        racingCarOutputController.printResult(bestDrivers);
    }


}
