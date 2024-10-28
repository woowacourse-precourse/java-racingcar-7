package racingcar.view;

import racingcar.service.RaceCarService;

public class OutputView {
    private final RaceCarService raceCarService;
    private final String EXEC_MESSAGE = "실행 결과";

    public OutputView(RaceCarService raceCarService) {
        this.raceCarService = raceCarService;
    }

    public void playRounds() {
        System.out.println(EXEC_MESSAGE);
        raceCarService.playEachRound();
    }

    public void announceWinner() {
        String winners = raceCarService.announceWinner();
        System.out.println("최종 우승자 : " + winners);
    }
}
