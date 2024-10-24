package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;

public class Application {
    static HashMap<String, Integer> carScores = new HashMap<String, Integer>();
    public static void main(String[] args) {
        // 차 이름 입력받고 이름을 하나씩 나누어 이름 배열에 저장 -> getCarNames()
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        String[] cars = names.split(",");

        // 시도 횟수 -> getRepeatNum()
        System.out.println("시도할 횟수는 몇 회인가요?");
        String repeatStr = Console.readLine();
        int repeat = Integer.parseInt(repeatStr);

        // 자동차 스코어 초기화해서 해시맵에 저장
        for (String car: cars) {
            carScores.put(car, 0);
        }
        System.out.println("\n실행 결과");

        // 입력받은 횟수만큼 차량 전진
        while (repeat-- > 0) {
            moveCars(cars); // 차량 이동
            showCurrentStatus(cars); // 현재 차수 실행 결과 출력
        }

        // 프로그램 완료: 우승자 출력
        getWinnerAndShow();
    }
    public static void moveCars(String[] cars) {
        for (int i=0; i<cars.length; i++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            // 4 이상이면 스코어 올리기 -> checkScoreAndMove()
            if (randomNum >= 4) {
                int curScore = carScores.get(cars[i]);
                carScores.put(cars[i], curScore+1);
            }
        }
    }

    public static void showCurrentStatus(String cars[]) {
        for (String carName : cars) {
            int score = carScores.get(carName);
            String scoreStr = makeScoreString(score);
            System.out.println(carName + " : "+ scoreStr);
        }
        System.out.println();
    }
    public static String makeScoreString(int score) {
        String result = "";
        while (score-- > 0) {
            result += "-";
        }
        return result;
    }
    public static void getWinnerAndShow() {

    }
}
