# java-racingcar-precourse
## 기능 목록
- 입력 값 받기
  - 게임이 진행될 횟수
  - 각 자동차 이름 부여
    - 만약 `" truck"`와 같이 공백이 포함된 경우 공백을 제거해 준다.
    - 입력된 이름순으로 저장될 수 있도록 LinkedHashMap 사용
- 입력 값 예외 처리
  - 잘못된 값이 들어오면 `IllegalArgumentException` 발생
  - 자동차 이름이 5자 초과 시
    - 앞뒤에 공백이 포함되었을 경우 공백 제거 후 기준
  - 이름에 공백만 있는 경우 ex) `" "`
  - 이름은 특수문자일 수 없다.
  - 자동차가 2대 이상 입력되지 않은 경우
  - 게임 진행 횟수 0 이하 입력 시
  - 게임 진행 횟수 정수형 이외의 타입 입력 시
  - 정수 범위를 넘어선 값을 입력 한 경우
- 랜덤 값을 이용한 정지 및 전진 판단 
  - 0 ~ 3의 값은 정지, 4 ~ 9의 값은 전진
  - 한 게임 종료 후 이름 출력
- 경주 완료 후 우승자 출력
  - 1명일 시 1명의 이름만 출력
  - 2명 이상일 시 `,`를 이용하여 구분하여 출력

## 구현 시 주의 사항
- 입력 받을 때 `camp.nextstep.edu.missionutils.Console`의 `readLine()` 사용할 것
- Random은 `cam.nextstep.edu.missionuntils.Randoms` 의 `pickNumberInRange()` 사용
- **다른 외부 라이브러리 절대 사용 금지**