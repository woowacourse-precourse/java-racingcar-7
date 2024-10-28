package racingcar;

public class RacingController {
    private final RacingView view;
    private final RacingService racingService;

    public RacingController(RacingView view, RacingService racingService) {
        this.view = view;
        this.racingService = racingService;
    }

    public void applicationRun() {
        racingService.ready(view);
        racingService.go(view);
        racingService.winner(view);
    }
}
