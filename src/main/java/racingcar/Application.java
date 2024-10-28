package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이를을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        CarNameParser carNameParser = new CarNameParser(input);

        if(input.equals("") || input.equals(","))
            throw new IllegalArgumentException();

        System.out.println("시도할 횟수는 몇 회인가요?");

        String num = Console.readLine();
        try {
            Integer.parseInt(num);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        int round = Integer.parseInt(num);

        System.out.println("실행 결과\n");
        RacingCarOutput racingCarOutput =new RacingCarOutput(round,carNameParser.Parser());
        racingCarOutput.Output();

        System.out.print("최종 우승자 :");
        racingCarOutput.Winner();
    }
}
