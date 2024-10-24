package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Setting {
    User user = new User();

    public List<Car> grantCarName(){
        List<String> carNames = user.grantCarName();
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    public int grantMoveCount(){
        return user.moves();
    }
}
