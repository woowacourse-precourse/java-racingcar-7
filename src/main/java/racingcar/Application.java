package racingcar;

import camp.nextstep.edu.missionutils.Console;


public class Application {

    static String inputCar;
    static int playCount;

    static ParseInput parseInput;

    static void Input()  {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCar= Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        playCount=Integer.parseInt(Console.readLine());

    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input();

        try {
            parseInput=new ParseInput(inputCar);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }

        String[] raceMember= parseInput.getRaceMember();
    }
}
