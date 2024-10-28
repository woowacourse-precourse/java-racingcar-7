package racingcar;

import java.util.List;

public class ResultView {
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
        sb.append("-".repeat(position));
        return sb.toString();
    }

    // 단독 또는 공동 우승자를 출력
    public static void printWinners(List<RacingCar> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
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
