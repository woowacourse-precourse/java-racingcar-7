package racingcar;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarController {
    private final RacingCarModel model;
    private final RacingCarView view;
    private HashMap<String, Integer> players;
    private LinkedList<String> winner;
    private int times;

    public RacingCarController(RacingCarModel model, RacingCarView view){
        this.model = model;
        this.view = view;
    }
    public void isValidName(String name){
        try {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            throw e;
        }
    }
    public void initGame(){
        setPlayersInfo();

        System.out.println("\n실행 결과");
        for(int i = 0; i < times; i++){
            startGame();
            view.currentState(players);
        }
        getResult();
        view.displayResult(winner);
    }
    public void setPlayersInfo(){
        String carName = view.getUserName();

        this.players = new LinkedHashMap<>();

        for (String n : carName.split(",")) {
            isValidName(n);
            this.players.put(n, 0);

        }
        this.times = view.getPlayTime();
    }

    public void startGame(){
        Set<String> carNames = players.keySet();
        Iterator<String> it = carNames.iterator();

        while(it.hasNext()){
            String carName = it.next();

            if (model.getRandomNumber() >= 4) {
                int currentMove = players.get(carName);
                players.replace(carName, ++currentMove);
            }
        }
    }

    public void getResult(){
        winner = new LinkedList<>();
        int maxValue = Collections.max(players.values());

        for (String key : players.keySet()) {
            if (players.get(key) == maxValue) {
                winner.add(key);
            }
        }
    }
}
