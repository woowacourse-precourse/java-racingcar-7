package racingcar.config;

import racingcar.model.Util.StringGenerator;
import racingcar.model.Util.WinnerCalculate;

public class UtilFactory {

    public static WinnerCalculate getCalculate(){
        return new WinnerCalculate();
    }

    public static StringGenerator getStringGenerator(){
        return new StringGenerator();
    }

}
