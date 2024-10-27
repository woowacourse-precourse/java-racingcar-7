package racingcar.view;

import racingcar.service.RacingCarService;

public class OutputView {
    private RacingCarService racingCarService;
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public OutputView(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void startRace() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
        racingCarService.startRace();
    }

    public void getFinalWinner() {
        String winners = racingCarService.getWinner();
        System.out.println("최종 우승자 : " + winners);
    }
}
