package racingcar.common.util;

import java.util.stream.Collector;
import racingcar.model.Drivable;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;

public class CarListCollector {

    /**
     * Drivable 인터페이스의 구현 객체를 RacingCarList로 수집하는 Collector를 반환합니다.
     *
     * @return Drivable 객체를 RacingCarList로 수집하기 위한 Collector
     */
    public static Collector<Drivable, ?, RacingCarList> toCarList() {
        return Collector.of(
                RacingCarList::new,
                CarListCollector::addCarIfRacingCar,
                CarListCollector::combineCarLists
        );
    }

    /**
     * RacingCar로 캐스팅하여 RacingCarList에 추가합니다.
     *
     * @param carList  RacingCarList
     * @param drivable Drivable 객체
     */
    private static void addCarIfRacingCar(RacingCarList carList, Drivable drivable) {
        if (drivable instanceof RacingCar racingCar) {
            carList.addCar(racingCar);
        } else {
            throw new IllegalArgumentException("Expected a RacingCar instance");
        }
    }

    /**
     * 두 개의 RacingCarList를 병합합니다.
     *
     * @param cl1 첫 번째 RacingCarList
     * @param cl2 두 번째 RacingCarList
     * @return 병합된 RacingCarList
     */
    private static RacingCarList combineCarLists(RacingCarList cl1, RacingCarList cl2) {
        cl1.getCarsCopy().addAll(cl2.getCarsCopy());
        return cl1;
    }
}
