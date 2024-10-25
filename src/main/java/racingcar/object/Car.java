package racingcar.object;

import racingcar.object.carEngine.CarEngine;
import racingcar.object.enums.DriveResult;
import racingcar.object.value.CarName;
import racingcar.object.value.CarRecord;
import racingcar.object.value.Mileage;

public class Car {

    private final CarEngine carEngine;
    private final CarName carName;

    private Mileage mileage;

    private Car(
            CarEngine carEngine,
            CarName carName,
            Integer mileage) {
        this.carEngine = carEngine;
        this.carName = carName;
        this.mileage = new Mileage(mileage);
    }

    public static Car ready(final CarEngine carEngine, final CarName carName) {
        if (carEngine == null) {
            throw new IllegalArgumentException("엔진은 비어있을 수 없습니다.");
        }
        if (carName == null) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        return new Car(carEngine, carName, 0);
    }

    public CarName getCarName() {
        return carName;
    }

    public Mileage getMileage() {
        return mileage;
    }

    public DriveResult tryDrive() {
        if (!carEngine.attemptDriveEngine()) {
            return DriveResult.FAILURE;
        }
        mileage = mileage.getIncreased();
        return DriveResult.SUCCESS;
    }

    public CarRecord record() {
        return new CarRecord(carName, mileage);
    }

}
