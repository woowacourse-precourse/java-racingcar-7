package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Racing {


    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();


        List<Car> cars = new ArrayList<>();

        String[] carNameList = input.split(",",-1);

        Set<String> nameSet = new HashSet<>();


        for(String carName : carNameList) {
            if (!nameSet.add(carName)) {
                throw new IllegalArgumentException();
            }

            Car car = new Car(new Name(carName));
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
                car.moveForward();
            }

            for(Car car : cars) {
                System.out.print(car.name.getName() +" : ");

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
            System.out.print(winners.get(i).name.getName());
            if(i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
