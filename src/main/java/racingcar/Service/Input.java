package racingcar.Service;

public class Input {
    public String[] getInput(String input){
        String[] inputList = input.split(",");
        for(String s : inputList){
            check(s);
        }
        return inputList;
    }

    public boolean check(String input){
        if(input.length()>5) throw new IllegalArgumentException("자동차 이름이 너무 길어요");
        return true;
    }
}
