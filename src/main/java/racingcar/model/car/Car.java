package racingcar.model.car;

import static java.lang.String.format;

public class Car {
    private final String name;
    private final MyProgress myProgress;

    private Car(final String name, final MyProgress myProgress) {
        this.name = name;
        this.myProgress = myProgress;
    }

    public static Car from(final String name, final MyProgress myProgress) {
        //TODO: validation
        return new Car(name, myProgress);
    }

    public boolean completedAllLap() {
        return myProgress.completedAllLap();
    }

    public void updateProgress() {
        myProgress.updatePosition();
        myProgress.updateRemainingLap();
    }

    public String myProgressSummary() {
        return format("%s : %s", name, myProgress.toString());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
