package racingcar;

import racingcar.randomgenerator.RandomGenerator;

public class Car {
    private static final int RANDOM_BOUNDARY = 9;
    private static final int COMPARISON_POINT = 4;
    private static final int START_POSITION = 0;
    private static final String ROUND_FINISH_FORMAT = "%s : %s";
    private static final String LINE_CHARACTER = "-";
    private final String name;
    private final RandomGenerator generator;
    public int position;

    public Car(String name, RandomGenerator generator){
        this.name = name;
        this.position =START_POSITION;
        this.generator = generator;
    }
    public void move(){
        if(generator.random(RANDOM_BOUNDARY)>=COMPARISON_POINT){
            position++;
        }
    }
    public int getPosition(){
        return this.position;
    }
    public String getMoveResult(){
        return ROUND_FINISH_FORMAT.formatted(this.name, LINE_CHARACTER.repeat(this.position));
    }
    public String getName(){
        return this.name;
    }
    public boolean isWinner(int winnerPosition){
        return this.position == winnerPosition;
    }
}
