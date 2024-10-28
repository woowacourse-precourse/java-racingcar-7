package racingcar.io;

public class JavaWriter implements Writer{
    @Override
    public void write(String message){
        System.out.println(message);
    }
}
