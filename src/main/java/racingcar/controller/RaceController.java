package racingcar.controller;

import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.service.GameService;
import racingcar.view.RaceView;
import racingcar.view.View;

public class RaceController implements Controller<RaceRequest> {

    private GameService gameService;

    public RaceController() {
        this.gameService = new GameService();
    }

    public View run(RaceRequest request) {
        RaceResponse response = gameService.startRace(request);
        return RaceView.createView(response);
    }

}
