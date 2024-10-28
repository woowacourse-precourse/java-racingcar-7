package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private List<Character> moveTo;

    public Car(){
        this.moveTo = new ArrayList<>();
    };

    public Car(String name){
        this.name=name;
        this.moveTo = new ArrayList<>(); // 초기화
         }

    public String getName(){
        return this.name;
    }

    public List<Character> getMoveTo() {
        return this.moveTo;
    }

    public static List<Car> createCars(String input){
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();
        for(String carName : carNames){
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static void randomMove(Car car){
        char hyphen = '-';
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4) {
            car.moveTo.add(hyphen);
        }
    }


    public static List<String> findWinner(List<Car> cars){
        Optional<Integer> maxSize = cars.stream()
                .map(car -> car.getMoveTo().size())
                .max(Integer::compareTo);


        List<String> maxCars = cars.stream()
                .filter(car -> car.getMoveTo().size() == maxSize.orElse(0)) // 최댓값과 같은 크기 필터링
                .map(Car::getName)
                .toList();

        return maxCars;
    }

}
