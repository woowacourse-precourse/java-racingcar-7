package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

class Input {

    private List<String> names;
    private int tryNumber;

    public Input(List<String> names, int tryNumber) {
        names = this.names;
        tryNumber = this.tryNumber;
    }

    public List<String> getNames() {
        return names;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Input input = getInput();
        

    }

    public static Input getInput() throws IllegalArgumentException {

        String input = Console.readLine();
        List<String> names = parseNames(input);

        input = Console.readLine();
        int tryNumber = getTryNumber(input);
        Console.close();

        return new Input(names, tryNumber);
    }

    public static List<String> parseNames(String input) throws IllegalArgumentException {

        if(input.startsWith(",") || input.endsWith(","))
            throw new IllegalArgumentException("공백의 이름은 넣을 수 없습니다.");

        String[] splitNames = input.split(",");

        for(String s : splitNames){
            if( !s.matches("^[a-zA-Z0-9,]*$"))
                throw new IllegalArgumentException("구분자는 ','만 가능합니다.");
            if(s.length() > 5 || s.equals(""))
                throw new IllegalArgumentException("각 이름은 1자 이상 5자 이하여야 합니다.");
        }

        return List.of(splitNames);
    }

    public static int getTryNumber(String input) throws IllegalArgumentException {

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
