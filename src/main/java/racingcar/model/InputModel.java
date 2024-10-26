package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.Parser;

public class InputModel {
    String carNames ;
    public InputModel(){
    }
    public String getName(){
        this.carNames = Console.readLine();
        return carNames;
    }
    public String [] getInput(){
        return carNames.split(",");
    }
    public int getPlayTime(){
        Parser parser = new Parser();
        String play_times = Console.readLine(); 
        return(parser.stringToInt(play_times));
    }

}