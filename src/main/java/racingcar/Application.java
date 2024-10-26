package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {

        System.out.println("자동차의 수를 입력해주세요");
        int countCars = Integer.parseInt(Console.readLine());

        System.out.println("자동차의 이름을 쉼표(,)로 구분해 입력해주세요 (5자 이하)");
        String[] carNames = (Console.readLine()).split(",");

        if (carNames.length != countCars) {
            throw new IllegalArgumentException("자동차의 수와 이름의 개수가 일치하지 않습니다");
        }

        Car[] cars = new Car[countCars];

        for (int i=0; i < countCars; i++) {

            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException(carNames[i] + ": 5자 이하여야 합니다");
            }

            cars[i] = new Car(carNames[i].trim());
        }

        System.out.println("이동횟수를 정수로 입력해주세요");
        int moveCount;
        try {
            moveCount = Integer.parseInt(Console.readLine());

            if (moveCount < 0) {
                throw new IllegalArgumentException("0이상의 값을 입력해주세요");
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수값을 입력해주세요");

        }

        System.out.println("실행 결과");

        for (int i = 0; i < moveCount; i++) {

            System.out.println((i + 1) + "회차 결과");

            for (int c = 0; c < countCars; c++) {
                cars[c].move(pickNumberInRange(0, 9));
                System.out.println(cars[c].getPosition());
            }
        }
        String winner = "";
        int maxPosition = 0;

        for (int i = 0; i < countCars; i++) {

            if (cars[i].getPosition().length() > maxPosition) {
                maxPosition = cars[i].getPosition().length();
                winner = cars[i].getName();

            } else if (cars[i].getPosition().length() == maxPosition) {
                winner += ", " + cars[i].getName();

            }
        }

        System.out.println("우승자는 " + winner + " 입니다");












    }
}
