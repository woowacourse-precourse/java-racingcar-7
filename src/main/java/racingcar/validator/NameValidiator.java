package racingcar.validator;

import java.util.regex.Pattern;

public class NameValidiator {

//    private static final String CAR_LIST_PATTERN = "^([a-zA-Z0-9가-힣])(,[a-zA-Z0-9가-힣])*$";
    private static final String CAR_LIST_PATTERN = "^[a-zA-Z0-9가-힣]+[a-zA-Z0-9가-힣" + "," + "]*[a-zA-Z0-9가-힣]";

    public void rightNameList(String cars) {
        if (!Pattern.compile(CAR_LIST_PATTERN).matcher(cars).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
