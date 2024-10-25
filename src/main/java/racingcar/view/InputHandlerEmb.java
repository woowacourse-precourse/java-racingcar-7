package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
public class InputHandlerEmb implements InputHandler {
    @Override
    public String carInput(){
        return Console.readLine();
    }
    @Override
    public String numberInput(){
        return Console.readLine();
    }
}
