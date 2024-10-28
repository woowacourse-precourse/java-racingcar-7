package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
public class JavaWriter implements Writer{
    @Override
    public void write(String message){
        System.out.println(message);
    }
}
