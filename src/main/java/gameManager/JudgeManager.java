package gameManager;


import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//max 값 판단, max를 가진 게이머 반환
public class JudgeManager {
    private static Set<String> winners;
    private static int highestScore;

    //static Map<String, Integer> gamerScores = GameManager.getGamerScores();

    //가장 높은 점수를 찾는 메서드
    private static int findHighestScore(Map<String, Integer> map) {
        highestScore = 0;
        for (int score : map.values()) {
            if (score > highestScore) highestScore = score;
        }
        return highestScore;
    }

    /*public int findHighestScore(Map<String, Integer> map){
        highestScore = 0;
        for(int score : map.values()){
            if(score>highestScore) highestScore = score;
        }
        return highestScore;
    }*/

    //winner가 있는지 확인하는 메서드
    private static boolean hasGamersWithHighestScore(Map<String, Integer> map) {
        return !map.isEmpty() && highestScore > 0;
    }

    //가장 높은 점수를 반환하는 메서드
    public static int getHighestScore(Map<String, Integer> map) {
        findHighestScore(map);
        return hasGamersWithHighestScore(map) ? highestScore : 0;
    }

    //map을 넣고 최고 값을 찾아?..
    private static Set<String> findWinners(Map<String, Integer> map, int highestScore) {
        winners = new HashSet<>();
        for (Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == highestScore)
                winners.add(e.getKey());
        }
        return winners;
    }

    public static Set<String> getWinners(Map<String, Integer> map, int highestScore) {
        return findWinners(map, highestScore);
    }

    public Set<String> judge(Map<String, Integer> map) {
        int hightestScore = getHighestScore(map);
        return getWinners(map, hightestScore);
    }

}
