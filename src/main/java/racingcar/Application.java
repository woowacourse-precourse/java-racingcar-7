package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");
        List<Car> cars = new ArrayList<>();

        for(String name : carNames){
            cars.add(new Car(name));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int numberOfRounds = Integer.parseInt(Console.readLine());

        for(int i = 0; i < numberOfRounds; i++){
            for (Car car : cars){
                if(Randoms.pickNumberInRange(0, 9) >= 4){
                    car.move();
                }
            }

            for(Car car : cars){
                System.out.println(car.getName() + " : " + car.displayPosition());
            }
            System.out.println();
        }

        int maxPosition = 0;
        for (Car car : cars){
            if(car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
            }
        }

        List<String> winners = new ArrayList<>();
        for(Car car : cars){
            if(car.getPosition() == maxPosition){
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
