package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carNames = getCarNames();
        int raceCount = getRaceCount();

        List<Car> cars = createCars(carNames);

        Race race = new Race(cars, raceCount);
        race.start();

    }
    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    private static int getRaceCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
    private static List<Car> createCars(String carNames){
        List<Car> cars = new ArrayList<>();
        String[] nameArr = carNames.split(",");

        for (String name : nameArr){
            String trimmedName = name.trim();
            checkNames(cars, trimmedName);
            cars.add(new Car(trimmedName));
        }
        return cars;
    }
    private static void checkNames(List<Car> cars, String name){
        if (name.length() >= 6){
            throw new IllegalArgumentException("길이 6 이상의 문자열");
        }
        for (Car car: cars){
            if (car.getName().equals(name))
                throw new IllegalArgumentException("중복된 자동차 이름");
        }
    }
}

