package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.*;

public class Application {

    public static final int MAX_CAR_NAME_LENGTH = 5;

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

        List<Car> cars = initializeCars(carNameList);
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