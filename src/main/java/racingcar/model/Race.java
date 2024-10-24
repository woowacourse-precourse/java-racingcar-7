package racingcar.model;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    private List<Car> cars;

    public void move(int rounds){
        for (int i =0; i < rounds; i++){
            for (Car car : cars){
                boolean carMove = Randoms.pickNumberInRange(0, 9) >= 4;
                car.race(carMove);
            }
        }
    }

    public Race(List<Car> cars) {
        this.cars = cars;
    }

}
