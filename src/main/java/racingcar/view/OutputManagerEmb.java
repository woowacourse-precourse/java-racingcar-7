package racingcar.view;

public class OutputManagerEmb implements OutputManager {
    @Override
    public void output(String message){
        System.out.println(message);
    }
}
