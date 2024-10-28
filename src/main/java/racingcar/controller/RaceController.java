package racingcar.controller;

import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.service.GameService;
import racingcar.service.RaceService;
import racingcar.view.RaceView;
import racingcar.view.View;

public class RaceController implements Controller<RaceRequest> {

    private GameService<RaceRequest, RaceResponse> gameService;

    public RaceController() {
        this.gameService = new RaceService();
    }

    public View run(RaceRequest request) {
        RaceResponse response = gameService.startGame(request);
        return RaceView.createView(response);
    }

}
