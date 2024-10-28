package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarsIntermediateView implements Observer{
    private static final String MOVE_DISTANCE_SYMBOL = "-";

    /**
     * Cars에서 한 번 전진할 때마다 진행 상태를 업데이트하여 화면에 출력한다.
     */
    @Override
    public void update(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(String.format("%s : %s"
                    , car.getName()
                    , MOVE_DISTANCE_SYMBOL.repeat(car.getMoveDistance())));
        }
        System.out.println();
    }
}
