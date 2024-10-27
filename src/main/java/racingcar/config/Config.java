package racingcar.config;

import racingcar.controller.InputParser;
import racingcar.controller.RacingController;
import racingcar.controller.format.RaceResultFormatter;
import racingcar.controller.handler.ConsoleInputHandler;
import racingcar.controller.handler.ConsoleOutputHandler;
import racingcar.service.RaceEngine;
import racingcar.service.RacingService;
import racingcar.util.random.RaceRandomGenerator;
import racingcar.util.random.RaceRandomGeneratorImpl;

public class Config {
    public RacingController racingController() {
        return new RacingController(racingService(), consoleInputHandler(), consoleOutputHandler());
    }

    public RacingService racingService() {
        return new RacingService(raceEngine());
    }

    public RaceRandomGenerator raceRandomGenerator() {
        return RaceRandomGeneratorImpl.getInstance();
    }

    public ConsoleInputHandler consoleInputHandler() {
        return new ConsoleInputHandler(new InputParser());
    }

    public RaceEngine raceEngine() {
        return new RaceEngine(raceRandomGenerator());
    }

    public ConsoleOutputHandler consoleOutputHandler() {
        return new ConsoleOutputHandler(new RaceResultFormatter());
    }
}
