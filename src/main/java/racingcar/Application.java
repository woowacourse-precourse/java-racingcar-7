package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼포(,)기준으로 구분");
        String nameInput = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryInput = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        List<String> carNames = delimiterCar(nameInput);

        String character = "-";

        for (int i = 0; i < tryInput; i++) {
            for (int j = 0; j < carNames.size(); j++) {
                System.out.println(carNames.get(j) + " : " + character.repeat(4) );
            }
            System.out.println();
        }
    }

    public static List<String> delimiterCar(String nameInput) {
        StringTokenizer st = new StringTokenizer(nameInput,",");
        List<String> carNames = new ArrayList<>();

        while (st.hasMoreTokens()) {
            carNames.add(st.nextToken());
        }
        return carNames;
    }

    public static boolean isForward() {
        int i = Randoms.pickNumberInRange(0,9);
        return i >= 4;
    }


//    public static String carMove(boolean input) {
//
//    }

}
