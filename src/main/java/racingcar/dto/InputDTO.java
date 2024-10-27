package racingcar.dto;

public class InputDTO {
    
    private final String[] carNameList;
    private final int turnCount;

    public InputDTO(String[] carNameList, int turnCount) {
        this.carNameList = carNameList;
        this.turnCount = turnCount;
    }

    public String[] getCarNameList() {
        return carNameList;
    }

    public int getTurnCount() {
        return turnCount;
    }
}
