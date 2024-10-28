# java-racingcar-precourse

## ✅ 구현할 기능 목록

### 1. 사용자 입력 처리
#### 1-1. 사용자 입력 받기
- [x] 사용자로부터 입력을 받음
  - 사용자로부터의 입력은 'camp.nextstep.edu.missionutils.Console'의 readLine() 활용
    - [x] 경주할 자동차 이름 (String, RacingCarInput)
    - [x] 시도할 횟수 (int, RacingCount)
#### 1-2. 예외 처리 사항
- [x] 빈 값을 입력받는 경우 경주를 진행할 수 없으므로 IllegalArgumentException 예외 처리를 진행

### 2. 문자열 분리 및 검증
#### 2-1. 문자열 분리
- [x] '경주할 자동차 이름'의 입력 값을 ',' 기준으로 문자열을 분리
#### 2-2. 검증
- [x] 분리된 문자열의 이름이 5자 이하인 경우에만 추가
- [x] 검증했을 때 5자 이하인 것이 없다면 IllegalArgumentException 예외 처리를 진행
- [x] 만약 구분자가 있음에도 이름이 빈 칸이 있다면 IllegalArgumentException 예외 처리를 진행

### 3. 경주 시작
#### 3-1. '시도할 횟수' 만큼 경주를 진행
- [x] 반복문 등을 통해 '시도할 횟수' 만큼 경주를 반복
#### 3-2. 경주 이동 조건
- 'camp.nextstep.edu.missionutils.Randoms'의 pickNumberInRange() 활용
  - pickNumberInRange()을 통해 주사위를 굴림
    - [x] 0 ~ 9 사이에서 무작위 값을 구한 뒤 4이상인 경우 전진
      - [x] 전진한 자동차의 출력은 (차량명) : (전진 길이)
        - (ex) pobi : ---
    - [x] 4 미만인 경우 전진하지 않은 값 출력

### 4. 경주 종료
#### 4-1. 출력하기
- [x] 멀리 이동한 자동차 거리 가져오기
- [x] 가장 멀리 이동한 '자동차 이름들을 출력'
  - [x] 출력 방식은 '최종 우승자 : (차량명)'을 따름
  - [x] 여러 차량이 있는 경우 쉼표로 구분하여 모두 표시해주어야 함

### 생각할 수 있는 추가 문제점
- 동명 이인은 존재할 수 있는가?