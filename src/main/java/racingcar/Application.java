package racingcar;

import camp.nextstep.edu.missionutils.Console;
import utils.ExceptionMessages;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = readString();

        Race race = new Race(names);
    private static String readString() {
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessages.UNEXPECTED_INPUT);
        }
    }
}
