package racingcar;

import racingcar.prompt.PromptModel;

public class CarRacing {

    private final int attempts;
    private final CarGroup carGroup;

    CarRacing(CarGroup carGroup, int attempts) {
        this.carGroup = carGroup;
        this.attempts = attempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public CarGroup getCarGroup() {
        return carGroup;
    }

    public PromptModel race() {
        PromptModel result = new PromptModel();

        /*
         * 별도의 메서드로 분리한다.
         * */
        for (int i = 0; i < attempts; i++) {
            carGroup.accelerateAll();
            result.add(carGroup.getDrivingRecords());
        }
        CarRacingWinner winner = new CarRacingWinner(carGroup);
        result.add(winner.getWinners());

        return result;
    }
}
