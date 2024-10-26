package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        makeCarListWithNames(carNames);
    }

    private void makeCarListWithNames(String[] carNames) {
        for (String carName : carNames) {
            this.cars.add(makeCar(carName));
        }
    }

    private Car makeCar(String name) {
        return new Car(name);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getTopRankCarName(){

        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getMoveCount()-o1.getMoveCount();
            }
        });

        List<String> result = new ArrayList<>();

        cars.forEach(car -> {

            if(result.size()==0){
                result.add(car.getName());
            }
            else{
                if(car.getMoveCount()==cars.get(0).getMoveCount()){
                    result.add(car.getName());
                }
            }

        });

        return result;

    }


}
