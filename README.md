# java-racingcar-precourse

#### 기능 구현 목록

- 입력, 출력 클래스 구현
- 입력받은 이름을 가지는 자동차 객체 생성
- 자동차 객체를 가지는 Map 일급 컬렉션 생성

  - 레이싱카를 일급 컬렉션에 넣는 메서드 구현
  - 레이싱카를 앞으로 이동시키는 메서드 구현
  - 레이싱카의 이동한 거리를 인덱스를 기준으로 return하는 메서드 구현
  - 레이싱카 중 제일 많이 이동한 레이싱카 List return하는 메서드 구현
  - 레이싱카를 인덱스 기준으로 return 해주는 메서드 구현
  - map의 size를 반환하는 메서드 구현
- 레이싱 진행을 위한 클래스 생성

  - 시도할 횟수를 입력 받기, 입력 받은 수만큼 반복

  - 자동차마다 랜덤한 수 할당

  - 만약 4 이상이상이면 RacingCar 객체에 이동한 거리에 + 1
  - 반복마다 레이싱 이동 거리 출력
  - 레이싱카 객체에 name을 리턴하는 메서드 구현
  - 반복이 종료 시 map을 순회하여 가장 큰 이동거리를 가진 자동차 List 반환
- 반환 받은 list를 ,로 구분해 출력
- IO 전과 후 처리를 할 IOPreprocessor 클래스 구현
  - Input된 문자열을 파싱하는 기능
  - 파싱 된 문자열 리스트를 참고해 RacingCar 객체를 생성하고 RacingCarTrace에 넣는 기능
  - 레이싱 중 Trace  출력																																																																																																																							 전 형식에 맞는 String으로 만드는 기능
  - 레이싱이 끝난 후 거리를 계산하고 최종 우승자를 return하는 기능
  - 최종 우승자를 형식에 맞춘 출력으로 파싱하는 기능
- main 함수에 조합

#### 예외 처리 목록

- 객체 생성 시 이름이 5자 이하인지 validation
- 입력된 이름에 영어, 한글 외의 문자나 숫자, 빈 문자열 등 다른 문자가 들어갔는지 validation
- 같은 이름이 2번 이상 있는지 validation
- 입력한 이름 문자열에서 빈 문자가 있는지 validation
