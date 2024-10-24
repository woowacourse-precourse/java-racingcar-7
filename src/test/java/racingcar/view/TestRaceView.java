package racingcar.view;

import java.util.List;

import racingcar.domain.view.RaceView;

public class TestRaceView extends RaceView {

	private List<String> mockNames;
	private int mockLap;

	public TestRaceView(List<String> mockNames, int mockLap) {
		this.mockNames = mockNames;
		this.mockLap = mockLap;
	}

	@Override
	public List<String> receiveCarNames() {
		return mockNames;
	}

	@Override
	public int receiveRaceLap() {
		return mockLap;
	}
}
