package racingcar;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int count;

    public Race(List<Car> cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public void runOneRound(){
        for(Car car : cars){
            car.moveOnceRandom();
        }
    }

    public void printLocations(){
        for(Car car : cars){
            System.out.println(car.getNameAndLocation());
        }
    }

    public void runRace(){
        System.out.println("실행 결과");
        for(int i = 0; i < count; i++){
            runOneRound();
            printLocations();
            System.out.println();
        }
    }

    public void showWinners(){
        int max = cars.stream().map(Car::getLocation).max(Integer::compareTo).orElse(Integer.MIN_VALUE);

        List<String> winners = new ArrayList<>();
        for(Car car : cars){
            if(car.getLocation() == max){
                winners.add(car.getName());
            }
        }

        String winnersOutput = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnersOutput);
    }
}
