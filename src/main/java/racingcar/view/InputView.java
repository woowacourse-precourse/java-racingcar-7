package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {

    public ArrayList<String> readCarNames(){
        String input = Console.readLine();
        String[] carNames = input.split(",");

        return Arrays.stream(carNames).collect(Collectors.toCollection(ArrayList::new));
    }

    public int readAttempts(){
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
