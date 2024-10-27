package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.sql.SQLOutput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            String inputNames = Console.readLine();
            String[] carNames = parseCarNames(inputNames);

            int rounds = Integer.parseInt(Console.readLine());

            Race race = new Race(carNames, rounds);
            race.start();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    private static String[] parseCarNames(String inputNames){
        return inputNames.split(",");
    }
}
