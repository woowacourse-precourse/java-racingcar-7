package racingcar;

import java.util.*;

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
    public void initGame(){
        setPlayersInfo();

        for(int i = 0; i < times; i++){
            startGame();
            view.currentState(players);
        }
        getResult();
        view.displayResult(winner);
    }
    public void setPlayersInfo(){
        String carName = view.getUserName();

        this.players = new HashMap<String, Integer>();

        for (String n : carName.split(",")) {
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
