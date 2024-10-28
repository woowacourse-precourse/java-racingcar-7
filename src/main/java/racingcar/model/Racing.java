package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Racing {
    protected final List<Car> cars = new ArrayList<>();

    public Racing(List<String> cars) {
        cars.forEach(name -> this.cars.add(new Car(name)));
    }
    public List<Car> getCars() {
        return cars;
    }

    public void round(){
        for(Car car : cars){
            int randomNumber = random();
            if(randomNumber >= 4){
                car.setDistance();
            }
        }
    }

    public int random(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public void sort(){
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getDistance() - o1.getDistance();
            }
        });
    }

}
