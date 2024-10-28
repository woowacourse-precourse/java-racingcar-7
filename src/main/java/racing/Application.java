package racing;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import racing.validation.InputValidator;

public class Application {
    private final static InputValidator validator = new InputValidator();
    public static void main(String[] args) {

        // todo : n회, 수행 레이싱 참가 차량 1개에 대해서 구현
        // 사용자로부터 자동차 이름을 입력받음
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String carNameStr = Console.readLine();
        String[] carNames = carNameStr.split(",");
        validator.validateCarNames(carNames);

        int carCnt = carNames.length;

        int[] carPositions = new int[carCnt];

        // 사용자로부터 시도할 횟수를 입력받음
//        System.out.println("시도할 횟수는 몇 회인가요?");
//        int gameRound = Integer.parseInt(Console.readLine());
//        validator.validateGameRound(gameRound);

        for (int carIdx = 0; carIdx < carCnt; carIdx++) {
            if (isForward()) carPositions[carIdx]++;
            System.out.println(carNames[carIdx] + ":" + drawLogLine(carPositions[carIdx]));
        }

    }
    private static boolean isForward() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private static String drawLogLine(int k) {
        return "-".repeat(Math.max(0, k));
    }

}
