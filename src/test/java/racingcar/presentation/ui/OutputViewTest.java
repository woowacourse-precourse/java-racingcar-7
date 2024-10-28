package racingcar.presentation.ui;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.application.service.winner.WinnerService;
import racingcar.domain.car.RacingCar;
import racingcar.domain.history.RacingHistory;
import racingcar.domain.winner.Winner;
import racingcar.domain.winner.repository.WinnerRepository;
import racingcar.infrastructure.persistence.InMemoryRacingCarRepository;
import racingcar.infrastructure.persistence.InMemoryRacingHistoryRepository;
import racingcar.infrastructure.persistence.InMemoryWinnerRepository;
import racingcar.presentation.enums.UiMessage;

class OutputViewTest {
    private OutputView outputView;
    private ByteArrayOutputStream outputStream;
    private WinnerService winnerService;
    private InMemoryRacingCarRepository racingCarRepository;
    private InMemoryRacingHistoryRepository historyRepository;
    private WinnerRepository winnerRepository;

    @BeforeEach
    void before(){
        outputView = new OutputView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        winnerService = new WinnerService();

        racingCarRepository = InMemoryRacingCarRepository.getInstance();
        historyRepository = InMemoryRacingHistoryRepository.getInstance();
        winnerRepository = InMemoryWinnerRepository.getInstance();
        racingCarRepository.clear();
    }

    @Test
    void 실행_결과_화면_출력_테스트() {
        historyRepository.saveRacingHistory(new RacingHistory("pobi", 1));
        historyRepository.saveRacingHistory(new RacingHistory("woni", 2));
        historyRepository.saveRacingHistory(new RacingHistory("jun", 3));

        outputView.outputRacingResultUi();
        String result = outputStream.toString();

        assertTrue(result.contains(UiMessage.UI_OUTPUT_EXECUTION_RESULT_MESSAGE.getMessage()));
        assertTrue(result.contains("pobi : -"));
        assertTrue(result.contains("woni : --"));
        assertTrue(result.contains("jun : ---"));
    }

    @Test
    void 우승자_결과_화면_출력_테스트(){
        winnerRepository.saveWinner(new Winner("pobi"));
        winnerRepository.saveWinner(new Winner("woni"));

        winnerService.saveWinners();
        outputView.outputWinnerUi();
        String result = outputStream.toString();

        assertTrue(result.contains(UiMessage.UI_OUTPUT_WINNER_RESULT_MESSAGE.getMessage()));
        assertTrue(result.contains("pobi"));
    }
}