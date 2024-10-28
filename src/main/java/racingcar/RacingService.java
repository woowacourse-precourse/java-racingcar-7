package racingcar;

public class RacingService {

    private final RacingDto dto = new RacingDto();

    public void ready(RacingView view) {
        view.raceReadyView(dto);
    }

    public void go(RacingView view) {
        view.raceGoView(dto);
    }

    public void winner(RacingView view) {
        view.winnerView(dto);
    }

}
