package racingcar.service;

public class SeparatorService {
    private String[] names;

    public String[] getNames() {
        return names;
    }

    public void separateName(String name) {
        names = name.split(",");
    }

}
