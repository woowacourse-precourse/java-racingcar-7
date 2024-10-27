package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Car {
    public final String carName;
    public  int position;

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

        Set<String> nameSet = new HashSet<>();


        for(String carName : carNameList) {

            if(carName.isEmpty() || carName.length() >5) {
                throw new IllegalArgumentException();
            }

            if (!nameSet.add(carName)) {
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

                if(randomValue >= 4) {
                    car.incrementPosition();
                }
            }

            for(Car car : cars) {
                System.out.print(car.carName +" : ");

                for(int j =0; j < car.position; j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }


        int maxPosition = 0;
        List<Car> winners = new ArrayList<>();

        for(Car car : cars) {
            if(car.position > maxPosition) {
                maxPosition = car.position;
            }
        }

        for(Car car : cars) {
            if(car.position == maxPosition) {
                winners.add(car);
            }
        }

        System.out.print("최종 우승자 : ");
        for(int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).carName);
            if(i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
