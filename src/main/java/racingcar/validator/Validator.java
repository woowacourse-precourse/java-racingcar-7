package racingcar.validator;


import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final int MAX_PLAYER_NAME_LENGTH = 5;

    public static void checkDuplicate(List<String> playerNames) {
        Set<String> uniquePlayerNames=new HashSet<>(playerNames);
        if(uniquePlayerNames.size()!=playerNames.size()){
            throw new IllegalArgumentException("중복된 이름은 허용하지 않습니다.");
        }
    }
    public static void checkMaxLength(List<String> playerNames) {
        for (String playerName: playerNames){
            if(playerName.length()>MAX_PLAYER_NAME_LENGTH){
                throw new IllegalArgumentException("5글자 이하만 가능합니다");
            }
        }
    }
    public static void checkOnlyRest(List<String> playerNames) {
        if(playerNames.isEmpty()){
            throw new IllegalArgumentException("플레이어 이름이 입력되지 않았습니다");
        }
    }
    public static void checkBlank(String userInput) {
        if(userInput.isBlank()) {
            throw new IllegalArgumentException("플레이어 이름이 입력되지 않았습니다");
        }
    }
    public static void checkPositive(int turn) {
        if(turn <=0){
            throw new IllegalArgumentException("0이하의 값은 허용되지 않습니다.");
        }
    }
}
