package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Input;
import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class InputUtil {

    private InputUtil(){

    }

    public static Input getInput() throws IllegalArgumentException {

        String input = Console.readLine();
        List<String> names = parseNames(input);

        input = Console.readLine();
        int tryNumber = getTryNumber(input);

        Console.close();

        return new Input(names, tryNumber);
    }

    public static List<RacingCar> getRacingCars(Input input) {

        List<RacingCar> racingCars = new ArrayList<>();
        for(String name: input.getNames())
            racingCars.add(new RacingCar(name));

        return racingCars;
    }

    private static List<String> parseNames(String input) throws IllegalArgumentException {

        if(input.startsWith(",") || input.endsWith(","))
            throw new IllegalArgumentException("공백의 이름은 넣을 수 없습니다.");

        String[] splitNames = input.split(",");

        for(String s : splitNames){
            if( !s.matches("^[a-zA-Z0-9,]*$"))
                throw new IllegalArgumentException("구분자는 ','만 가능합니다.");
            if(s.length() > 5 || s.isEmpty())
                throw new IllegalArgumentException("각 이름은 1자 이상 5자 이하여야 합니다.");
        }

        return List.of(splitNames);
    }

    private static int getTryNumber(String input) throws IllegalArgumentException {

        int tryNumber;
        try {
            tryNumber = Integer.parseInt(input);
            if(tryNumber < 1)
                throw new IllegalArgumentException();

        } catch(Exception e) {
            throw new IllegalArgumentException("시도 횟수는 자연수를 입력해야 합니다.");
        }

        return tryNumber;
    }
}
