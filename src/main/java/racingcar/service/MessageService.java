package racingcar.service;

import racingcar.domain.Message;
import racingcar.domain.car.Cars;
import racingcar.domain.race.Result;

public class MessageService {
    private final String RESULT_MESSAGE = "실행 결과";
    private final String WINNER_MESSAGE = "최종 우승자 : ";

    public Message generateResultMessage(Result result) {
        StringBuilder message = new StringBuilder();

        message.append(RESULT_MESSAGE);
        message.append(System.lineSeparator());
        message.append(result.generateResultMessage());

        return new Message(message.toString());
    }

    public Message generateWinnerMessage(Cars cars) {
        StringBuilder message = new StringBuilder();

        message.append(WINNER_MESSAGE);
        message.append(String.join(", ", cars.getWinners()));

        return new Message(message.toString());
    }
}
