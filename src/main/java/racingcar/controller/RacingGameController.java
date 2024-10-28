package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.CarPlayer;
import racingcar.model.RoundRecord;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private RacingGameService racingGameService;
    private final ArrayList<CarPlayer> carPlayerList = new ArrayList<>();
    private final ArrayList<RoundRecord> roundRecordList = new ArrayList<>();

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private void initialize() {
        int roundCount = inputView.getTrial();
        ArrayList<String> playerList = inputView.getPlayersList();

        if (playerList != null) {
            for (String player : playerList) {
                CarPlayer carPlayer = new CarPlayer();
                carPlayer.setName(player);
                carPlayerList.add(carPlayer);
            }
        }

        for (int i = 0; i < roundCount; i++) {
            RoundRecord roundRecord = new RoundRecord();
            roundRecordList.add(roundRecord);
        }

        this.racingGameService = new RacingGameService(carPlayerList, roundRecordList);
    }

    public void start() {
        inputView.inputGameInfo();

        initialize();

        racingGameService.gameInnerLogic();

        outputView.setGameResult(racingGameService.getRoundRecordList());
        outputView.setGameWinner(racingGameService.getWinnerList());
        outputView.printGameResult();
    }
}
