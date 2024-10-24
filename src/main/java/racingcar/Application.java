package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    private void printRequestingCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private String getCarNamesInput() {
        return Console.readLine();
    }

    private void validateNotEmpty(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.") ;
        }
    }

    private String[] splitNamesByComma(String str) {
        return str.split(",");
    }

    private void validateMinimumTwoCars(String[] cars) {
        if (cars.length < 2) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void validateNameLength(String str) {
        if (str.length() > 5) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void printRequestingRaceRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
}
