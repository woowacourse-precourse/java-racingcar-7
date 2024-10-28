# java-racingcar-precourse

1.**입력 받기**

- readLine을 이용하여 경주할 자동차와 시도할 횟수를 입력
- inputManager클래스에 입력 받기 기능 구현

2.**입력 받은 값 처리**

- 입력 받은 경주할 자동차를 구분자를 통해 나누어 리스트에 넣기(SplitString클래스에 구현)
- 입력 받은 시도 횟수를 정수로 변환(Conversion클래스에 구현)
- 0 ~ 9 사이의 랜덤한 정수 받기(randomNumber사용)(RandomNumberGenerator클래스에 구현)
- 랜덤한 정수가 4 이상인지 비교(Comparison클래스에 구현)
- 경기 트랙 생성 및 트랙 추가(RacingTrack클래스에 구현)
- 경기 현황 출력(Application클래스에 print로 구현)

3.**예외 처리**

- 입력한 경주할 자동차 이름이 6자 이상일 경우 IllegalArgumentException 호출 
- 입력한 시도 횟수에 정수가 아닌 문자가 입력될 경우 IllegalArgumentException 호출
- Validation클래스에 구현

4. **결과 처리 및 출력**

- 경기가 끝난 트랙을 가져와 트랙의 길이를 통해 우승자를 추출하고 출력
- WinningIndex클래스를 통해 우승자의 index 위치를 구하고 Application클래스에서 for문을 통해 인덱스 위치의 우승자를 추출해서 출력  