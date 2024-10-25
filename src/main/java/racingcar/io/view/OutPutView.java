package racingcar.io.view;

import racingcar.dto.CarsDto;

public class OutPutView {
    private final RacePositionView racePositionView;
    private final WinnerView winnerView;

    public OutPutView(RacePositionView racePositionView, WinnerView winnerView) {
        this.racePositionView = racePositionView;
        this.winnerView = winnerView;
    }

    public void showRacePosition(CarsDto racePositionDto) {
        racePositionView.showRacePosition(racePositionDto);
    }

    public void showWinner(CarsDto carList) {
        winnerView.showWinner(carList);
    }
}
