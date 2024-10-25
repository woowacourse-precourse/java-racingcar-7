package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 입력값 확인
        // 자동차들의 이름
        String inputStr = Console.readLine();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) " + inputStr);

        // 사용자는 몇번의 이동을 할 것인지를 입력할 수 있어야 한다.
        String repeatRaceNum = Console.readLine();
        int repeatRaceIntNum = Integer.parseInt(repeatRaceNum);
        System.out.println("시도할 횟수는 몇 회인가요? : " + repeatRaceIntNum);

        String[] carNames = splitCarsName(inputStr);
        int[] carProgressArr = new int[carNames.length];
        for (int i = 0; i < repeatRaceIntNum; i++) {
            for (int car_ind = 0; car_ind < carNames.length; car_ind++) {
                int carProgress = canProgressWithRandomNum();
                carProgressArr[car_ind] += carProgress;
                printCarNameProgress(carNames[car_ind], carProgressArr[car_ind]);
            }
            System.out.println();
        }

    }

    public static String[] splitCarsName(String test) {
        // 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
        // 입력 예시 : pobi,woni,jun
        String[] carsName = test.split(",");
        return carsName;
    }

    public static int canProgressWithRandomNum() {
        // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            return 1;
        }
        return 0;
        // System.out.println(randomNum);
    }

    public static void printCarNameProgress(String carName, int progressNum) {
        String progressBar = "-".repeat(progressNum);
        System.out.println(carName + " : " + progressBar);
    }
}