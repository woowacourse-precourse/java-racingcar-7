package racingcar.component;

public class RacingCar implements Comparable<RacingCar> {

    private final String name;
    private final Odometer odometer;
    private final Engine engin;

    public RacingCar(String name) {
        this.name = name;
        this.odometer = new Odometer();
        this.engin = new Engine();
    }

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

    public int getTotalDistance() {
        return odometer.getTotalDistance();
    }

    @Override
    public int compareTo(RacingCar compared) {
        return this.getTotalDistance() - compared.getTotalDistance();
    }

    public boolean isNotLoserWith(RacingCar compared) {
        return this.compareTo(compared) >= 0;
    }

}
