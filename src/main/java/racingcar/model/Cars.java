package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.exception.ErrorCode;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(final List<String> carNames) {
        makeCarListWithNames(carNames);
    }

    private void makeCarListWithNames(final List<String> carNames) {

        carNames.stream()
                .peek(this::checkDuplicateCarName)
                .map(this::makeCar)
                .forEach(cars::add);
    }

    private void checkDuplicateCarName(final String carName) {

        if (cars.stream().anyMatch(car -> car.getName().equals(carName))) {
            throw new IllegalArgumentException(ErrorCode.CANT_INSERT_DUPLICATE_CAR_NAME.getMessage());
        }

    }

    private Car makeCar(String name) {
        return new Car(name);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getTopRankCarName(){

        sortByMoveCount();

        List<String> result = new ArrayList<>();

        cars.forEach(car -> makeRankResult(result, car));

        return result;

    }

    private void makeRankResult(final List<String> result, final Car car) {

        if(result.size()==0){
            result.add(car.getName());
        }
        else{
            if(car.getMoveCount()==cars.get(0).getMoveCount()){
                result.add(car.getName());
            }
        }
    }

    private void sortByMoveCount() {
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getMoveCount()-o1.getMoveCount();
            }
        });
    }


}
