package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private List<Character> path;

    public Car(){
        this.path = new ArrayList<>();
    };

    public Car(String name){
        this.name=name;
        this.path = new ArrayList<>(); // 초기화
         }

    public String getName(){
        return this.name;
    }

    public List<Character> getPath() {
        return this.path;
    }

    public static List<Car> createCars(String input){
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();
        for(String carName : carNames){
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static void tryRandomMove(Car car){
        char hyphen = '-';
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4) {
            car.path.add(hyphen);
        }
    }


    public static List<String> findWinningCars(List<Car> cars){
        Optional<Integer> maxSize = cars.stream()
                .map(car -> car.getPath().size())
                .max(Integer::compareTo);


        List<String> winingCars = cars.stream()
                .filter(car -> car.getPath().size() == maxSize.orElse(0)) // 최댓값과 같은 크기 필터링
                .map(Car::getName)
                .toList();

        return winingCars;
    }

}
