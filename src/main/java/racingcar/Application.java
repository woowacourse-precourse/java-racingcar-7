package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String readed = Console.readLine();

        String[] cars = readed.split(",");

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());

        int[] result = new int[cars.length];
        int max = 0;


        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < result.length; j++) {
                int number = Randoms.pickNumberInRange(0, 9);
                if (number >= 4) { result[j] += 1; }
                max = Math.max(max, result[j]);

                System.out.printf("%s : %s\n", cars[j], "-".repeat(result[j]));
            }
            System.out.println();
        }

        System.out.print("최종 우승자 : ");
        int maxItem = 0;

        for(int i = 0; i < cars.length; i++) {
            if (result[i] == max) maxItem += 1;
        }

        for(int i = 0; i < cars.length; i++) {
            if (maxItem == 1) {
                System.out.print(cars[i]);
                maxItem -= 1;
            } else if (maxItem > 1) {
                System.out.print(cars[i] + ", ");
                maxItem -= 1;
            }
        }
    }
}
