package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private RacingCar() {
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
        try {
            int count = Integer.parseInt(attemptCount);

            System.out.println("\n실행 결과");
            for(int i = 0; i < count; i++) {
                for(Car car : carArray) {
                    car.move();
                    System.out.println(car.getName()+" : " + "-".repeat(car.getMoveCount()));
                }
                System.out.println();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
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
