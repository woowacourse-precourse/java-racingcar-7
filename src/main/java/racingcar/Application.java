package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser(",", 5);
        InputResult inputResult = inputParser.process();

        System.out.println();
    }
}