package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        /* Split names */
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();
        if (input == null) {
            throw new IllegalArgumentException();
        }


        String[] cars = input.split(",");
        int numberOfCars = cars.length;

        for (int i = 0; i < numberOfCars; i++) {
            cars[i] = cars[i].trim();
            if(cars[i].length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        /* Setup Cars */
        Car[] carList = new Car[numberOfCars];
        for (int i = 0; i < numberOfCars; i++) {
            carList[i] = new Car(cars[i]);
        }

        /* Race begin */
        System.out.println("시도할 횟수는 몇 회인가요?");

        int n;
        try {
            n = Integer.parseInt(Console.readLine());
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        System.out.println();

        System.out.println("실행 결과");

        for (int t = 0; t < n; t++) {
            for (int i = 0; i < numberOfCars; i++) {
                carList[i].drive();
                carList[i].printDistance();
            }
            System.out.println();
        }

        /* Get maximum distance */
        int maxDistance = carList[0].getDistance();

        for (int i = 0; i < numberOfCars; i++) {
            if (maxDistance < carList[i].getDistance()){
                maxDistance = carList[i].getDistance();
            }
        }

        /* Find winners */
        String[] winners = new String[numberOfCars];
        int numberOfWinners = 0;
        for (int i = 0; i < numberOfCars; i++) {
            if (maxDistance == carList[i].getDistance()){
                winners[numberOfWinners++] = carList[i].getName();
            }
        }

        /* Print winners */
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < numberOfWinners; i++) {
            System.out.print(winners[i]);
            if(i < numberOfWinners - 1){
                System.out.print(", ");
            }
        }

    }
}
