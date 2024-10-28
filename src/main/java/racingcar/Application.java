package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int round = 0;
        String userInput;

        Race race = new Race();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        userInput = Console.readLine();

        if(userInput.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열입니다.");
        }
        if(!userInput.matches("[a-zA-Z,]+")) {
            throw new IllegalArgumentException("잘못된 문자열입니다.");
        }

        race.setCarListByName(userInput);

        System.out.println("시도할 횟수는 몇 회인가요?");
        userInput = Console.readLine();

        if(userInput.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열입니다.");
        }
        if(!userInput.matches("[0-9]+")) {
            throw new IllegalArgumentException("잘못된 숫자입니다.");
        }

        round = Integer.parseInt(userInput);

        if(round <= 0) {
            throw new IllegalArgumentException("잘못된 숫자입니다.");
        }

        race.StartRace(round);
        race.printWinner();
    }
}
