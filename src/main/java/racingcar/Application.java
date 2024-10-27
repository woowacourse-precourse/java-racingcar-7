package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;




class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        position = 0;
    }

    public void incrementPosition() {
        position+=1;
    }
}
public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        List<Car> cars = new ArrayList<>();

        String[] carNameList = input.split(",",-1);

        for(String carName : carNameList) {

            if(carName.isEmpty() || carName.length() >5) {
                throw new IllegalArgumentException();
            }

            Car car = new Car(carName);
            cars.add(car);
        }
        int roundNumber = 0;
        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            roundNumber = Integer.parseInt(Console.readLine());

            if(roundNumber < 1) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        for(int i =0; i<roundNumber; i++) {

            for(Car car : cars) {
                int randomValue = Randoms.pickNumberInRange(0,9);

                if(randomValue > 4) {
                    car.incrementPosition();
                }
            }

        }

    }
}
