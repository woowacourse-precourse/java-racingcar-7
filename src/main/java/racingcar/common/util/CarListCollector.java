package racingcar.common.util;

import java.util.stream.Collector;
import racingcar.model.CarList;
import racingcar.model.Drivable;

public class CarListCollector {

    /**
     * Drivable 인터페이스의 구현 객체를 CarList로 수집하는 Collector를 반환합니다.
     *
     * @return Drivable 인터페이스의 구현체를 CarList로 수집하기 위한 Collector
     */
    public static Collector<Drivable, ?, CarList> toCarList() {
        return Collector.of(
                CarList::new, // 수집기의 결과를 위한 새로운 CarList 생성
                CarList::addCar, // 요소를 CarList에 추가하는 accumulator
                CarListCollector::mergeCarLists // 두 개의 CarList를 병합하는 combiner
        );
    }

    /**
     * 두 개의 CarList를 병합합니다.
     *
     * @param cl1 첫 번째 CarList
     * @param cl2 두 번째 CarList
     * @return 병합된 CarList
     */
    private static CarList mergeCarLists(CarList cl1, CarList cl2) {
        cl1.getCarsCopy().addAll(cl2.getCarsCopy());
        return cl1;
    }
}
