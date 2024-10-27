package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static Racingcar racingcar;
    public static void main(String[] args) {
        racingcar = input();
        racingcar.racing();
        printResult();
    }

    public static Racingcar input(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputString = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String count = Console.readLine();

        return new Racingcar(inputString, count);
    }

    private static void printResult(){
        System.out.println(racingcar.getResult());
    }

}