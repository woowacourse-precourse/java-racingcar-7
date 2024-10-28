package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        String[] cars = camp.nextstep.edu.missionutils.Console.readLine().split(",");

        System.out.println("시도할 횟수는 몇 회인가요?");
        int maxTryCnt = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        int currentTryCnt = 0;
        int[] currentRecord = new int[]{0, 0, 0};

        System.out.println();
        System.out.println("실행결과");

        testValidInput(cars);

        while (currentTryCnt < maxTryCnt) {
            raceOneTurn(cars, currentRecord);
            currentTryCnt++;
            System.out.println();
        }
    }

    public static void testValidInput(String[] cars) {

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].length() > 5) {
                throw new IllegalArgumentException("입력이올바르지 않습니다");
            }
        }
    }

    static void raceOneTurn(String[] cars, int[] currentRecord) {
        for (int i = 0; i < cars.length; i++) {
            moveAndPrintCar(cars[i], currentRecord, i);
        }
    }

    static void moveAndPrintCar(String carName, int[] currentRecord, int index) {
        int randNum = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
        if (randNum >= 4) {
            currentRecord[index]++;
        }
        System.out.println(carName + " : " + "-".repeat(currentRecord[index]));
    }

}