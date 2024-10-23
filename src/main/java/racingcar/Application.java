package racingcar;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());

        String[] cars = input.split(",");

        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하이어야 합니다.");
            }
        }

        int countOfCars = cars.length;

        String[][] carArray = new String[countOfCars][2];

        for (int i = 0 ; i < countOfCars ; i++) {
            carArray[i][0] = cars[i];
            carArray[i][1] = "";
        }

        while (count-- > 0) {
            for (int i = 0; i < countOfCars; i++) {

                int randNum = Randoms.pickNumberInRange(0,9);

                if (randNum >= 4) {
                    carArray[i][1] += "-";
                }
                System.out.println(carArray[i][0] + " : " + carArray[i][1]);
            }
            System.out.println();
        }

        int result = 0;

        for (int i = 0; i < countOfCars; i++) {
            if (carArray[i][1].length() > result) {
                result = carArray[i][1].length();
            }
        }

        List<String> winners = new ArrayList<>();

        for (int i = 0; i < countOfCars; i++) {
            if (carArray[i][1].length() == result) {
                winners.add(carArray[i][0]);
            }
        }

        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
