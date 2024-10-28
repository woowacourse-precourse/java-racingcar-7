package racingcar.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Input {
    public String[] getCarInput(String input){
        if(input.charAt(input.length()-1)==',') throw new IllegalArgumentException("자동차 이름 공백");

        String[] inputList = input.split(",");
        for(String s : inputList){
            System.out.println(s);
            checkCar(s);
        }
        if(isDuplicateName(inputList)) throw new IllegalArgumentException("입력값 중복");
        return inputList;
    }

    public int getCntInput(String input){
        int cnt;
        checkCnt(input);
        cnt = Integer.parseInt(input);
        return cnt;
    }

    public boolean checkCar(String input){
        if(input.isEmpty() || input==null || input=="") throw new IllegalArgumentException("자동차 이름 공백");
        if(input.length()>5) throw new IllegalArgumentException("자동차 이름이 너무 길어요");
        return true;
    }

    public boolean isDuplicateName(String[] inputList){
        boolean duplicate = false;
        Set<String> inputSet = new HashSet<>(Arrays.asList(inputList));
        if(inputList.length != inputSet.size()){
            throw new IllegalArgumentException("자동차 이름 중복");
        }

        return duplicate;
    }

    public void checkCnt(String input){
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) throw new IllegalArgumentException("입력이 숫자가 아님");
        if(Integer.parseInt(input)<=0) throw new IllegalArgumentException("횟수가 0이하임");
    }
}
