package racingcar.component;

import racingcar.race.RacingPlayer;

public class RacingCar implements RacingPlayer<RacingCar> {

    private final String name;
    private final Odometer odometer;
    private final Engine engin;

    public RacingCar(String name) {
        this.name = name;
        this.odometer = new Odometer();
        this.engin = new Engine();
    }

    @Override
    public int move() {
        int distance = 0;
        if (engin.start()) {
            distance += 1;
        }
        int accumulatedMileage = odometer.increase(distance);
        doAfterMove(accumulatedMileage);
        return distance;
    }

    private void doAfterMove(int accumulatedMileage) {
        String oneMileMark = "-";
        String totalMileMark = oneMileMark.repeat(accumulatedMileage);
        System.out.printf("%s : %s", name, totalMileMark);
        System.out.println();
    }

    @Override
    public int getTotalDistance() {
        return odometer.getTotalDistance();
    }

    @Override
    public String getPlayerName() {
        return name;
    }

}
