package racingcar;

import racingcar.client.Client;
import racingcar.client.RacingClient;

public class Application {
    public static void main(String[] args) {
        Client client = new RacingClient();
        client.request();
    }
}
