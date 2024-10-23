# 자동차 경주 게임

## 구현할 기능 목록

## Car
1. 자동차 생성 및 초기화
  - 이름 설정
  - 위치 초기화

2. 이름 유효성 검증 (validateName)
  - null 체크
  - 공백 체크
  - 이름 길이 체크(5자 이하)

3. 자동차 이동 관리
  - moveForward: 위치 증가
  - getPosition: 현재 위치 반환

4. 상태 출력
  - getCurrentPosition: 현재 상태 문자열 반환
    (예: "name : ---")

## RaceGame
1. 게임 초기화
  - 자동차 목록 생성
  - 입력된 이름으로 자동차 객체 생성

2. 게임 진행
  - playRound: 단일 라운드 진행
  - playGame: 전체 게임 진행
  - 라운드별 이동 처리

3. 우승자 판단
  - getMaxPosition: 최대 이동 거리 계산
  - getWinners: 우승자 목록 생성

4. 결과 출력
  - printCurrentStatus: 현재 상태 출력
  - printWinners: 우승자 출력

## RaceUtil
1. 이름 처리
  - parseCarNames: 입력 문자열을 쉼표로 분리

2. 이동 판단
  - canMove: 랜덤값 기반 이동 여부 결정(boolean)
    - true : 전진
    - false : 정지

3. 유효성 검증
  - validateAttempts: 시도할 횟수 유효성 검증



## 🚀 프로그래밍 요구 사항 준수 여부

### 프로그래밍 요구사항 1
- [x] JDK 21 버전 사용
- [x] 프로그램 실행의 시작점은 Application의 main()
- [x] build.gradle 파일 변경 금지
- [x] 외부 라이브러리 사용 금지
- [x] System.exit() 호출 금지
- [x] 파일, 패키지 이름 변경 금지

### 프로그래밍 요구사항 2
- [x] indent depth 2까지만 허용
- [x] 삼항 연산자 사용하지 않음
- [x] 메서드가 한 가지 일만 하도록 구현
- [x] JUnit 5와 AssertJ를 이용한 테스트 작성

### 라이브러리 사용
- [x] Random 값은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 사용
- [x] 사용자 입력은 camp.nextstep.edu.missionutils.Console의 readLine()을 사용