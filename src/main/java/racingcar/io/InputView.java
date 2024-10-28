package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InputView {

    private static final int MAX_PLAYER_NAME_LENGTH=5;

    public List<String> readPlayerNameList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput=Console.readLine();

        checkBlank(userInput);
        List<String> playerNames= List.of(userInput.split(","));
        checkOnlyRest(playerNames);
        checkMaxLength(playerNames);
        checkDuplicate(playerNames);
        return playerNames;
    }

    public Integer readTurnFromInput() {
        final int turn;
        System.out.println("시도할 횟수는 몇 회인가요?");
        final String userInput=Console.readLine();

        try {
            turn=Integer.parseInt(userInput);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자이외의 값은 허용되지 않습니다.");
        }
        if(turn<=0){
            throw new IllegalArgumentException("0이하의 값은 허용되지 않습니다.");
        }
        return turn;
    }

    private void checkDuplicate(List<String> playerNames) {
        Set<String> uniquePlayerNames=new HashSet<>(playerNames);
        if(uniquePlayerNames.size()!=playerNames.size()){
            throw new IllegalArgumentException("중복된 이름은 허용하지 않습니다.");
        }
    }

    private static void checkMaxLength(List<String> playerNames) {
        for (String playerName: playerNames){
            if(playerName.length()>MAX_PLAYER_NAME_LENGTH){
                throw new IllegalArgumentException("5글자 이하만 가능합니다");
            }
        }
    }

    private void checkOnlyRest(List<String> playerNames) {
        if(playerNames.isEmpty()){
            throw new IllegalArgumentException("플레이어 이름이 입력되지 않았습니다");
        }
    }

    private void checkBlank(String userInput) {
        if(userInput.isBlank()) {
            throw new IllegalArgumentException("플레이어 이름이 입력되지 않았습니다");
        }
    }
}
