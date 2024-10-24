package racingcar.dto;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.*;
import static java.util.Arrays.*;

public class RacingCarDTO {

    private final ArrayList<String> racingCarNameList;
    private final int numberOfRacing;

    public RacingCarDTO(String racingCarNameString, String numberOfRacingString) {

        // " "으로 구분된 각 이름을 배열로 나눈 후 ArrayList로 변환
        String[] splitRacingCarNameList = racingCarNameString.split(" ");
        this.racingCarNameList = new ArrayList<>(asList(splitRacingCarNameList));
        this.numberOfRacing = parseInt(numberOfRacingString);
    }

    public ArrayList<String> getRacingCarNameList() {
        return racingCarNameList;
    }

    public int getNumberOfRacing() {
        return numberOfRacing;
    }
}
