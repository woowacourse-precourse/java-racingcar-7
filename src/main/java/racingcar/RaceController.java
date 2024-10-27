package racingcar;

public class RaceController {
    private RaceService service;
    private RaceView view;

    public RaceController(RaceService service, RaceView view) {
        this.service = service;
        this.view = view;
    }

}
