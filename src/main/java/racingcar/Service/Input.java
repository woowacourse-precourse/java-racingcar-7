package racingcar.Service;

public class Input {
    public String[] getCarInput(String input){
        String[] inputList = input.split(",");
        for(String s : inputList){
            checkCar(s);
        }
        return inputList;
    }

    public int getCntInput(String input){
        int cnt;
        checkCnt(input);
        cnt = Integer.parseInt(input);
        return cnt;
    }

    public boolean checkCar(String input){
        if(input.length()>5) throw new IllegalArgumentException("자동차 이름이 너무 길어요");
        return true;
    }

    public void checkCnt(String input){
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) throw new IllegalArgumentException("입력이 숫자가 아님");
        if(Integer.parseInt(input)<=0) throw new IllegalArgumentException("횟수가 0이하임");
    }
}
