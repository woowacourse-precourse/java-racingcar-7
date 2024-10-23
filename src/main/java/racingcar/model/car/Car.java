package racingcar.model.car;

import static java.lang.String.format;

import racingcar.model.race.MyProgress;

public class Car {
    private final String name;
    private final MyProgress myProgress;

    private Car(final String name, final MyProgress myProgress) {
        this.name = name;
        this.myProgress = myProgress;
    }

    public static Car of(final String name, final MyProgress myProgress) {
        //TODO: validation
        return new Car(name, myProgress);
    }

    public boolean completedAllLap() {
        return myProgress.completedAllLap();
    }

    public String myProgress() {
        return format("%s : %s", name, myProgress.toString());
    }

    public void updateProgress(final int moveDistance) {
        myProgress.updatePositionBy(moveDistance);
        myProgress.updateRemainingLap();
    }
}
