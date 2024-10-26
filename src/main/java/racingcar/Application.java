package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

import static java.lang.Integer.*;

public class Application {

    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MIN_RANDOM_VALUE = 0;
    public static final int MAX_RANDOM_VALUE = 9;
    public static final int ADVANCE_THRESHOLD = 4;

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();

        if (carName == null || carName.isEmpty()){
            throw new IllegalArgumentException("경주할 자동차 이름 입력 필요함.");
        }

        List<String> carNameList = Arrays.asList(carName.split(","));

        for (int i = 0; carNameList.size() > i; i++){
            if (carNameList.get(i).length() > MAX_CAR_NAME_LENGTH){
                throw new IllegalArgumentException("자동차의 이름은 5글자를 넘길 수 없습니다.");
            }
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountInput = Console.readLine();
        int tryCount = Integer.parseInt(tryCountInput);

        List<Car> cars = initializeCars(carNameList);
        for(int i = 0; tryCount > i; i++){
            for (Car car : cars) {
                int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
                if (randomValue >= ADVANCE_THRESHOLD) {
                    car.advance();
                }
                System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println();
        }
        List<Integer> positions = cars.stream().map(Car::getPosition).toList();

        OptionalInt maxOptional = positions.stream().mapToInt(Integer::intValue).max();

        int maxPosition = maxOptional.orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
   }

    private static List<Car> initializeCars(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNameList) {
            cars.add(new Car(name));
        }
        return cars;
    }

    static class Car {
        private final String carName;
        private int position = 0;

        public Car(String carName) {
            this.carName = carName;
        }

        public String getCarName() {
            return carName;
        }

        public int getPosition() {
            return position;
        }

        public void advance() {
            position++;
        }
    }
}