package racingcar.input;

public class DataParsing {
    private DataParsing(){}

    public String[] parseData(String input){
        String[] parsedItems = input.split(",");
        for (String item : parsedItems) {
            if(item.length() > 5){
                throw new IllegalArgumentException("이름의 길이가 5자를 넘으면 안됩니다.");
            }
        }
        return parsedItems;
    }
}