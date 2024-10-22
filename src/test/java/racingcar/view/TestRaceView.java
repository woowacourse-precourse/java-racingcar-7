package racingcar.view;

import racingcar.domain.view.RaceView;

public class TestRaceView extends RaceView {

	private String mockNames;
	private int mockLap;

	public TestRaceView(String mockNames, int mockLap){
		this.mockNames = mockNames;
		this.mockLap = mockLap;
	}

	@Override
	public String receiveCarNames(){
		return mockNames;
	}

	@Override
	public int receiveRaceLap(){
		return mockLap;
	}
}
