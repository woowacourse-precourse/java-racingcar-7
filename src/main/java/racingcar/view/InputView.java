package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Utils;

import java.util.List;

public class InputView {

    public static List<String> inputCarName(){

        return Utils.splitInputCar(Console.readLine());
    }

    public static int inputTrialCount(){

        return Integer.parseInt(Console.readLine());
    }

}
