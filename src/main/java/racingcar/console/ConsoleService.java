package racingcar.console;

import racingcar.domain.Racing;
import racingcar.value.RacingCarList;
import racingcar.value.TotalLaps;
import racingcar.value.WinnerPlayerList;

public final class ConsoleService {
    private final InputService inputService;
    private final OutputService outputService;

    private ConsoleService(InputService inputService, OutputService outputService) {
        this.inputService = inputService;
        this.outputService = outputService;
    }

    public static ConsoleService init() {
        return new ConsoleService(InputService.init(), OutputService.init());
    }

    public Racing createRacing() {
        final var racingCarList = this.inputRacingCarList();
        final var totalLaps = this.inputTotalLaps();
        return Racing.of(racingCarList, totalLaps);
    }

    public void printStart() {
        this.outputService.printStart();
    }

    public void printCurrentLapResult(final RacingCarList racingCarList) {
        this.outputService.printCurrentLapResult(racingCarList);
    }

    public void printWinners(final WinnerPlayerList winnerPlayerList) {
        this.outputService.printWinners(winnerPlayerList);
    }

    private RacingCarList inputRacingCarList() {
        this.outputService.printInputRacingCarList();
        return this.inputService.readRacingCarList();
    }

    private TotalLaps inputTotalLaps() {
        this.outputService.printInputTotalLaps();
        return this.inputService.readTotalLaps();
    }
}