package racingcar.object.carEngine;

public class AlwaysOnDriveCarEngine implements CarEngine {

    @Override
    public boolean attemptDriveEngine() {
        return true;
    }

}
