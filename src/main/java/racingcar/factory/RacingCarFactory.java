package racingcar.factory;

public class RacingCarFactory {

    private final NamingProcessor namingProcessor;
    private final String namingInput;

    public RacingCarFactory(String namingInput) {
        this.namingProcessor = new NamingProcessor();
        this.namingInput = namingInput;
    }

}
