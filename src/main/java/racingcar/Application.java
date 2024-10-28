package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            String inputNames = readCarNames();
            String inputCount = readCount();
            GameService game = new GameService(inputNames, inputCount);
            game.play();
            printWinner(game);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    private static String readCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    private static void printWinner(GameService game) {
        String winners = game.getWinnersNames();
        System.out.println("최종 우승자 : " + winners);
    }
}

