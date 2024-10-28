package racingcar.view;

import racingcar.model.Cars;
import racingcar.raceInterface.Observer;

public class RaceView implements OutputHandler, Observer {
    private Cars cars;

    @Override
    public void displayOneTrial() {
        for (String carName : cars.keySet()) {
            System.out.println(carPrintForm(carName));
        }
        System.out.println();
    }

    private String carPrintForm(String carName) {
        return carName + " : " + "-".repeat(cars.get(carName));
    }

    @Override
    public void displayWinner() {
        String winners = cars.getWinnerNames(cars.findWinScore());
        System.out.println(winners);
    }

    @Override
    public void updateGoTrial(Cars goTrialResult) {
        this.cars = goTrialResult;
        displayOneTrial();
    }

    @Override
    public void updateWinner(Cars winnerResult) {
        this.cars = winnerResult;
        displayWinner();
    }

    //test 시 cars 객체 설정용
    public void setCars(Cars cars) {
        this.cars = cars;
    }

    @Override
    public void printRaceStartMessage() {
        System.out.println("\n실행 결과");
    }

    @Override
    public void printWinnerMessage() {
        System.out.print("최종 우승자 : ");
    }
}
