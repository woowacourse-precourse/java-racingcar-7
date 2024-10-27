package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<String> names) {
        List<Car> cars = names.stream().map(Car::getInstance).toList();
        validateDuplicateName(cars);
        this.cars = cars;
    }

    private void validateDuplicateName(List<Car> cars) {
        List<String> carNames = cars.stream().map(car -> car.getName()).toList();
        Set<String> distinctCarNames = cars.stream().map(car -> car.getName()).collect(Collectors.toSet());
        if(!Objects.equals(carNames.size(), distinctCarNames.size())){
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static Cars getInstance(String input) {
        return new Cars(Arrays.stream(input.split(",")).toList());
    }

    public List<Car> getCars(){
        return Collections.unmodifiableList(cars);
    }

    public void moveAll(List<Integer> randomNumbers){
        validateSize(randomNumbers);
        for(int i=0; i<randomNumbers.size(); i++){
            Integer randomCount = randomNumbers.get(i);
            cars.get(i).move(randomCount);
        }
        print();
    }

    private void validateSize(List<Integer> randomNumbers) {
        if(!Objects.equals(randomNumbers.size(), cars.size())){
            throw new IllegalArgumentException("자동차 수에 맞게 무작위 값이 입력되어야합니다.");
        }
    }

    private void print() {
        System.out.println();
    }
    public List<String> getCarNameWithLongestDistance(){
        List<Car> cars = this.cars.stream().sorted().toList();
        Integer maxDistance = cars.get(0).getDistance();
        return this.cars.stream().filter(car -> Objects.equals(maxDistance, car.getDistance()))
                .map(car -> car.getName()).toList();
    }

    public int getSize(){
        return this.cars.size();
    }
}
