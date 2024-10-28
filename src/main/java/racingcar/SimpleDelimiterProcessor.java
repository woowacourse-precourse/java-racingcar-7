package racingcar;

public class SimpleDelimiterProcessor implements Processor{
    @Override
    public String[] process(String input) {
        // todo: 공백은? 입력이 null? 각 입력의 길이가 5글자 이상인 경우?
        return input.split(",");
    }
}
