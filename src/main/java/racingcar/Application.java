package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // 사용자로부터 자동차 이름을 입력받음
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<RacingCar> racingCars = userInput();
        System.out.println("시도할 횟수는 몇 회인가요?");
        // 사용자로부터 횟수를 입력받음
        int times = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        for (int i = 0; i < times; i++) {
            carRun(racingCars);
            print(racingCars);
        }
    }

    // 사용자로부터 입력을 받아 경주할 자동차 이름 배열 반환
    public static List<RacingCar> userInput() {
        String names = Console.readLine();
        return concatNames(names);
    }

    public static List<RacingCar> concatNames(String names) {
        List<RacingCar> nameList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(names, ",");
        while (st.hasMoreTokens()) {
            nameList.add(new RacingCar(st.nextToken()));
        }
        return nameList;
    }

    public static List<RacingCar> carRun(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            // 랜덤한 값이 4 이상일때만 전진
            if (4 <= Randoms.pickNumberInRange(0, 9)) {
                int position = racingCar.getPosition();
                racingCar.setPosition(++position);
            }
        }
        return racingCars;
    }

    public static void print(List<RacingCar> racingCars) {
        StringBuilder sb = new StringBuilder();
        for (RacingCar racingCar : racingCars) {
            sb.append(racingCar.getName())
                    .append(" : ")
                    .append(positionBuilder(racingCar.getPosition()))
                    .append("\n");
        }
        System.out.println(sb);
    }

    public static String positionBuilder(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
