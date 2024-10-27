package racingcar;

import racingcar.prompt.PromptModel;

public class CarRacing {

    private final int attempt;
    private final CarGroup carGroup;

    CarRacing(CarGroup carGroup, int attempt) {
        this.carGroup = carGroup;
        this.attempt = attempt;
    }

    public int getattempt() {
        return attempt;
    }

    public CarGroup getCarGroup() {
        return carGroup;
    }

    public PromptModel race() {
        PromptModel result = new PromptModel();

        /*
         * 별도의 메서드로 분리한다.
         * */
        for (int i = 0; i < attempt; i++) {
            carGroup.accelerateAll();
            result.add(carGroup.getDrivingRecords());
        }
        CarRacingWinner winner = new CarRacingWinner(carGroup);
        result.add(winner.getWinners());

        return result;
    }
}
