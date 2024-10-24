package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<Name> names = Name.createNames(input);

        RaceRound raceRound = RaceRound.inputRounds();
        System.out.println("입력된 자동차 이름 : ");
        for (Name name : names) {
            System.out.println(name.getName());
        }

        System.out.println("시도할 횟수 : " + raceRound.getRounds());

    }
}
