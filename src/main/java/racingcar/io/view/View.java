package racingcar.io.view;

import racingcar.dto.CarsDto;

public class View {
    private final RacePositionView racePositionView;
    private final WinnerView winnerView;
    private final InputView inputView;

    public View(RacePositionView racePositionView, WinnerView winnerView, InputView inputView) {
        this.racePositionView = racePositionView;
        this.winnerView = winnerView;
        this.inputView = inputView;
    }

    public void showRacePosition(CarsDto racePositionDto) {
        racePositionView.showRacePosition(racePositionDto);
    }

    public void showWinner(CarsDto carList) {
        winnerView.showWinner(carList);
    }

    public void showCarNameExplanation() {
        inputView.showCarNameExplanation();
    }

    public void showAttemptExplanation() {
        inputView.showAttemptExplanation();
    }
}
