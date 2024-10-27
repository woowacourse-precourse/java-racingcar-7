package gameManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameManager {
    private static Map<String, Integer> gamerScores;

    public GameManager() {
        this.gamerScores = new HashMap<>();
    }

    public static Map<String, Integer> getGamerScores() {
        return gamerScores;
    }

    //이름과 초기값 설정
    public void setName(String name) {
        gamerScores.put(name, 0);
    }

    //gamer를 map에 담고 초기값 0 설정
    public void setCarNames(String[] gamers) {
        for (String name : gamers) {
            setName(name);
        }
    }

    //gamer의 이름 반환
    public Set<String> getAllGamer() {
        return gamerScores.keySet();
    }

    //이름 넣고 값 가져오기
    public Integer getScore(String name) {
        return gamerScores.getOrDefault(name, 0);
    }

    //점수 더하기
    public void addScore(String name, int addScore) {
        gamerScores.put(name, getScore(name) + addScore);
    }


}