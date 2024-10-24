package racingcar.object;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.object.carEngine.AlwaysOnDriveCarEngine;
import racingcar.object.carEngine.BrokenCarEngine;
import racingcar.object.carEngine.CarEngine;
import racingcar.object.carEngine.RandomCarEngine;
import racingcar.object.enums.DriveResult;
import racingcar.object.value.CarName;
import racingcar.object.value.CarRecord;
import racingcar.object.value.Mileage;

class CarTest {

    private static final Class<IllegalArgumentException> COMMON_EXCEPTION = IllegalArgumentException.class;

    @Test
    void ready로_새차를_생성가능() {
        CarName newCarName = new CarName("새차이름");
        assertThat(Car.ready(new RandomCarEngine(), newCarName))
                .isInstanceOf(Car.class);
    }

    @Test
    void getCarName로_CarName을_획득가능() {
        CarName newCarName = new CarName("새차이름");
        Car newCar = Car.ready(new RandomCarEngine(), newCarName);
        CarName getCarName = newCar.getCarName();

        assertThat(getCarName).isEqualTo(newCarName);
    }

    @Test
    void getMileage로_Mileage_획득가능() {
        CarName newCarName = new CarName("새차이름");
        Car newCar = Car.ready(new RandomCarEngine(), newCarName);
        Mileage newCarMileage = newCar.getMileage();
        Mileage noRunCarMileage = new Mileage(0);
        int resultOfCompareTo = newCarMileage.compareTo(noRunCarMileage);

        assertThat(resultOfCompareTo).isEqualTo(0);
    }

    @Test
    void tryDrive_성공시_주행거리가_증가한다() {
        CarName newCarName = new CarName("새차이름");
        CarEngine carEngineForSuccess = new AlwaysOnDriveCarEngine();
        Car newCar = Car.ready(carEngineForSuccess, newCarName);
        Mileage mileageBeforeDriving = newCar.getMileage();

        DriveResult driveResult = newCar.tryDrive();
        Mileage mileageAfterDriving = newCar.getMileage();

        assertThat(driveResult).isEqualTo(DriveResult.SUCCESS);
        assertThat(mileageAfterDriving.compareTo(mileageBeforeDriving))
                .isGreaterThan(0);
        assertThat(mileageAfterDriving.distance())
                .isEqualTo(mileageBeforeDriving.distance() + 1);
    }

    @Test
    void tryDrive_실패시_주행거리가_그대로다() {
        CarName newCarName = new CarName("새차이름");
        CarEngine carEngineForSuccess = new BrokenCarEngine();
        Car newCar = Car.ready(carEngineForSuccess, newCarName);
        Mileage mileageBeforeDriving = newCar.getMileage();

        DriveResult driveResult = newCar.tryDrive();
        Mileage mileageAfterDriving = newCar.getMileage();

        assertThat(driveResult).isEqualTo(DriveResult.FAILURE);
        assertThat(mileageAfterDriving.compareTo(mileageBeforeDriving))
                .isEqualTo(0);
        assertThat(mileageAfterDriving.distance())
                .isEqualTo(mileageBeforeDriving.distance());
    }

    @Test
    void record로_차량의_주행상태를_기록한다() {
        Car car = Car.ready(new AlwaysOnDriveCarEngine(), new CarName("새차이름"));
        car.tryDrive(); // 주행거리 1 증가
        CarRecord record = car.record();

        assertThat(record.carName()).isEqualTo(car.getCarName());
        assertThat(record.mileage()).isEqualTo(new Mileage(1));
    }

}