package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ApplicationInputView {
    public static String input() {
        return Console.readLine();
    }

    public static int getInt(){
        try{
            return Integer.parseInt(input());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("해당 입력에서는 정수를 입력해야 합니다.");
        }
    }
}
