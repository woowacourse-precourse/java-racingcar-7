package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<String> cars = getCars();

        int count = getCount();

        List<Integer> moves = new ArrayList<>(Collections.nCopies(cars.size(),0));

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < cars.size(); j++) {
                if (determineMovement()) moves.set(j, moves.get(j) + 1);
            }
        }
    }

    private static List<String> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> cars = new ArrayList<String>(Arrays.asList(input.split(",")));
        return cars;
    }

    private static int getCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());
        return count;
    }

    private static boolean determineMovement() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) return true;
        return false;
    }
}