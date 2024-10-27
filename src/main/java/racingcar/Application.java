package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String readed = Console.readLine();

        String[] cars = readed.split(",");

        int count = Integer.parseInt(Console.readLine());

        int[] result = new int[cars.length];
        int max = 0;

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < result.length; j++) {
                int number = Randoms.pickNumberInRange(0, 9);
                if (number >= 4) { result[j] += number; }
                max = Math.max(max, result[j]);
            }
        }

        for (int j : result) {
            if (j == max) {
                System.out.printf("최종 우승자 : %s%n", String.join(",", cars));
            }
        }


    }
}
