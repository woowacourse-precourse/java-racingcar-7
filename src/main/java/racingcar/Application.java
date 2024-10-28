package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.이름은 쉼표(,) 기준으로 구분");
        String racingCarsNames = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptCount = Console.readLine();

        List<Car> carArray = createCar(racingCarsNames);

        printRacing(attemptCount, carArray);

        printWinner(carArray);
    }



    public static List<Car> createCar(String racingCarsNames) {
        if(racingCarsNames == null || racingCarsNames.isBlank()) {
            throw new IllegalArgumentException();
        }

        List<Car> carArray =  new ArrayList<>();
        String[] carsNames = racingCarsNames.split(",");

        for (String carName : carsNames) {
            if(carName.isBlank()) {
                continue;
            }

            carName = carName.trim();

            if(carName.length() > 5) {
                throw new IllegalArgumentException();
            }

            carArray.add(new Car(carName));
        }

        if(carArray.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return carArray;
    }

    public static void printRacing(String attemptCount, List<Car> carArray) {
        System.out.println("\n실행 결과");
        for(int i = 0; i < Integer.parseInt(attemptCount); i++) {
            for(Car car : carArray) {
                car.move();
                System.out.println(car.getName()+" : " + "-".repeat(car.getMoveCount()));
            }
            System.out.println();
        }
    }

    public static void printWinner(List<Car> carArray) {
        int maxMoveCount = 0;
        List<String> winnerNames = new ArrayList<>();

        for (Car car : carArray) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }

        for (Car car : carArray) {
            if(car.getMoveCount() >= maxMoveCount) {
                winnerNames.add(car.getName());
            }
        }

        String winner = String.join(", ", winnerNames);

        System.out.println("최종 우승자 : " + winner);
    }
}
