package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<String> names = new ArrayList<>();
    public List<String> winner = new ArrayList<>();
    private List<Integer> count = new ArrayList<>();

    public void addPlayers(List<String> names){
        this.names.addAll(names);
        for (int i = 0; i < names.size(); i++) {
            count.add(0);
        }
    }
    public void addCount(int indexNum){
        count.set(indexNum, count.get(indexNum) + 1);
    }

    public int theMaxInt(){
        int max=count.get(0);
        for(int i=0;i<names.size();i++){
            if(count.get(i) <count.get(i+1)){
                max=count.get(i+1);
            }
        }
        return max;
    }
    public List<String> whoIsWinner(){
        int max=theMaxInt();
        for(int i=0;i<names.size();i++){
            if(count.get(i)==max){
                winner.add(names.get(i));
            }
        }
        return winner;
    }

    public List<String> getNames() {
        return names;
    }

    public List<Integer> getCount(){ return count; }
}


