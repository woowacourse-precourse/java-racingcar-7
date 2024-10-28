package racingcar.service;

public class SeperatorService {
    private final String[] names;

    public String[] getNames() {
        return names;
    }

    public SeperatorService(String s) {
        names=s.split(",");
    }

}
