package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
public class JavaReader implements Reader{
    @Override
    public String read(){
        return Console.readLine();
    }
}
