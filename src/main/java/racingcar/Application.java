package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String readed = Console.readLine();

        String[] cars = readed.split(",");

        int count = Integer.getInteger(Console.readLine());

        int[] result = new int[cars.length];

        for (int i = 0; i < count; i++) {
            int number = Randoms.pickNumberInRange(0, 9);

        }
    }
}
