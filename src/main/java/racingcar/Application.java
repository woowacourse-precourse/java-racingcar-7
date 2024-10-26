package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int num = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");

        String[] carList = input.split(",");
        int[] carIndex = new int[carList.length];

        for (int i = 0; i < num; i++) {
            for (int k = 0; k < carList.length; k++) {
                int randomValue = Randoms.pickNumberInRange(0, 9);
                if (randomValue >= 4) {
                    carIndex[k]++;
                }
            }
            for (int j = 0; j < carList.length; j++) {
                System.out.println(carList[j] + " : " + "-".repeat(carIndex[j]));
            }
            System.out.println();
        }
    }
}
