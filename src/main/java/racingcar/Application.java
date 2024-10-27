package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        String[] carNames = parseCars(input);
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        input = Console.readLine();

        int attempts = Integer.parseInt(input);
        for (int i = 0; i < attempts; i++) {
            printAttempts(cars);
            System.out.println();
        }
        printWinners(cars);
    }

    public static class Car {
        private String name;
        private int position;

        public Car(String name) {
            this.name = name;
            this.position = 0;
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }

        public void move() {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                position++;
            }
        }
    }

    private static String[] parseCars(String input) {
        return input.split(",");
    }

    private static void printAttempts(Car[] cars) {
        for (Car car : cars) {
            car.move();
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private static void printWinners(Car[] cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        StringBuilder winners = new StringBuilder();
        for(Car car : cars) {
            if(car.getPosition() == maxPosition) {
                if (winners.length() > 0){
                    winners.append(", ");
                }
                winners.append(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + winners.toString());
    }
}