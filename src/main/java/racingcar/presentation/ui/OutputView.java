package racingcar.presentation.ui;

import racingcar.application.service.history.RacingHistoryService;
import racingcar.domain.car.repository.RacingCarRepository;
import racingcar.domain.winner.Winner;

import java.util.List;
import racingcar.infrastructure.persistence.InMemoryRacingCarRepository;
import racingcar.presentation.enums.UiMessage;

public class OutputView {
    private final RacingHistoryService racingHistoryService;
    private final RacingCarRepository racingCarRepository;

    public OutputView() {
        this.racingHistoryService = new RacingHistoryService();
        this.racingCarRepository = InMemoryRacingCarRepository.getInstance();
    }

    // TODO: 실행 결과 화면 출력
    public void outputRacingResultUi() {
        System.out.println(UiMessage.UI_OUTPUT_EXECUTION_RESULT_MESSAGE.getMessage());
        racingHistoryService.printRacingResult();
    }

    // TODO: 최종 우승자 화면 출력
    public void outputWinnerUi(List<Winner> winners) {
    }
}
