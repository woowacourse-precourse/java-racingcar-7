package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Participant {
    System.out.println("시도할 횟수는 몇 회인가요?");
    String input_turn = Console.readLine();
    int turn_count = Integer.parseInt(input_turn);
    private String name;
    private int move_count;

    public Participant(String name){
        this.name = name;
        this.move_count = 0;
    }

    public void updateMoveCount(){
        this.move_count+=1;
    }

    public int getMoveCount(){
        return move_count;
    }
}
