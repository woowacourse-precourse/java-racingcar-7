package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String str = Console.readLine();

        StringTokenizer st = new StringTokenizer(str,",");

        int count = st.countTokens();

        List<String> cars = new ArrayList<>();
        List<Integer> location = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            cars.add(st.nextToken());
            location.add(0);
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < count; j++) {
                int randomNum = Randoms.pickNumberInRange(0,9);

            }

        }
    }
}
