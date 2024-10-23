package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private static final int CAR_LIST_MAX_SIZE = 10;
    private final List<Car> carList;
    public RacingCars(String readLine) {
        List<Car> tmpList = new ArrayList<>();
        String[] nameArray = readLine.split(",");
        for (String name : nameArray) {
            Car car = new Car(name);
            tmpList.add(car);
        }
        validationListSize(tmpList);
        this.carList = tmpList;
    }

    private void validationListSize(List<Car> tmpList) {
        if (tmpList.size() > CAR_LIST_MAX_SIZE) {
            throw new IllegalArgumentException("[ERROR] 경주할 자동차의 수는 " + CAR_LIST_MAX_SIZE +"이하만 가능합니다.");
        }
    }
}
