package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            String inputNames = readCarNames();
            GameService game = new GameService(inputNames);
            System.out.println("입력된 자동차 이름:");
            game.getCars().forEach(car -> System.out.println(car.getName()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
}

