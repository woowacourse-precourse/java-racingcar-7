package view;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import model.Car;

public class CarView {

    public void showInputCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showInputRaceCountMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public String generateScoreDisplay(int score) {
        if (score <= 0) {
            return "";
        } else {
            return "-".repeat(score); // 점수만큼 "-" 반복
        }
    }

    public void showWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        System.out.println("최종 우승자 : " + winnerNames);
    }

    public String readCarNames() {
        return Console.readLine();
    }

    public String readRaceCount() {
        return Console.readLine();
    }
}
