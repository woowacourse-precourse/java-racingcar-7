package racingcar.service;

public class SeperatorService {
    private  String[] names;

    public String[] getNames() {
        return names;
    }

    public void seperate(String s) {
        names=s.split(",");
    }

}
