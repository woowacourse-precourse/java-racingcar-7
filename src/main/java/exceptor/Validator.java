package exceptor;

import constant.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.LetterCounter.letterCounter;

public class Validator {
    public static void validatePlayerTurn(String turn){
        try{
            int convertedTurn = Integer.parseInt(turn);
            validatePositivePlayerTurn(convertedTurn);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("입력한 값이 정수가 아님");
        }
    }

    public static void validatePositivePlayerTurn(int turn){
        if(turn < 0){
            throw new IllegalArgumentException("입력한 값이 음수임");
        }
    }

    public static void validateNameLengthLimit(String name){
        if(letterCounter(name) > Constants.RACING_CAR_NAME_LIMIT){
            throw new IllegalArgumentException("글자 수가 기준보다 많음");
        }
    }

    public static void validateDuplicatedName(ArrayList<String> group){
        Set<String> removedDuplicategroup = new HashSet<>(group);
        if(removedDuplicategroup.size() != group.size()){
            throw new IllegalArgumentException("중복된 이름이 들어갔음");
        }
    }

    public static void validateBlankName(String name){
        if(name.isBlank()){
            throw new IllegalArgumentException("이름이 비어있음");
        }
    }
}
