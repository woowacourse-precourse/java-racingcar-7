package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // 사용자로부터 자동차 이름들을 입력받음
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<RacingCar> racingCars = userInput();

        System.out.println("시도할 횟수는 몇 회인가요?");
        // 사용자로부터 횟수를 입력받음
        int times;
        try {
            times = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            // 숫자가 아닌 값 입력시 IllegalArgumentException 발생
            throw new IllegalArgumentException();
        }
        // 0이하의 값 입력 시 예외 처리
        if (times < 1) {
            throw new IllegalArgumentException();
        }

        // 매 차수별 실행 결과를 출력
        System.out.println("실행 결과");
        for (int i = 0; i < times; i++) {
            carRun(racingCars);
            printResult(racingCars);
        }

        // 최종 우승자 출력
        System.out.print("최종 우승자 : ");
        List<RacingCar> winners = winners(racingCars);
        printWinners(winners);
    }

    // 사용자로부터 입력을 받아 경주할 자동차 이름 배열 반환
    public static List<RacingCar> userInput() {
        String names = Console.readLine();
        return splitNames(names);
    }

    // 쉼표(,) 기준으로 이름을 나눠 List에 저장
    public static List<RacingCar> splitNames(String names) {
        List<RacingCar> nameList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(names, ",");
        while (st.hasMoreTokens()) {
            String name = st.nextToken();
            nameList.add(new RacingCar(name));
        }
        return nameList;
    }

    // 랜덤한 값을 기준으로 차량을 전진
    public static void carRun(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            // 랜덤한 값이 4 이상일때만 전진
            if (4 <= Randoms.pickNumberInRange(0, 9)) {
                racingCar.move();
            }
        }
    }

    // 차수별 실행 결과를 출력
    public static void printResult(List<RacingCar> racingCars) {
        StringBuilder sb = new StringBuilder();
        for (RacingCar racingCar : racingCars) {
            sb.append(racingCar.getName())
                    .append(" : ")
                    .append(positionBuilder(racingCar.getPosition()))
                    .append("\n");
        }
        System.out.println(sb);
    }

    // RacingCar의 position을 dash(-)로 표현
    public static String positionBuilder(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    // 우승자를 추려 List에 저장
    public static List<RacingCar> winners(List<RacingCar> racingCars) {
        List<RacingCar> winners = new ArrayList<>();
        int maxProceed = maxProceed(racingCars);
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() == maxProceed) {
                winners.add(racingCar);
            }
        }
        return winners;
    }

    // RacingCar List중 최대로 전진한 값을 구함
    public static int maxProceed(List<RacingCar> racingCars) {
        int maxProceed = 0;
        for (RacingCar racingCar : racingCars) {
            if (maxProceed < racingCar.getPosition()) {
                maxProceed = racingCar.getPosition();
            }
        }
        return maxProceed;
    }

    // 단독 또는 공동 우승자를 출력
    public static void printWinners(List<RacingCar> winners) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i).getName());
            // 우승자의 마지막이 아닌경우 쉼표를 추가
            if (i != winners.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}
