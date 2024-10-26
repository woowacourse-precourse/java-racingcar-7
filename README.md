# java-racingcar-precourse

# < controller >
## 1) Controller 
* runningGame //게임 실행하기
---
# < model >
## 1) Car
* settingCarPosition // 자동차 위치 정하기
* checkCarNameAvailable // 자동차 이름 길이 확인

## 2) Cars
* splitCarNames // 자동차이름 문자열 나누기
* createCars // 자동차그룹 만들기

## 3) Game
* oneRoundGame // 게임 한 바퀴 실행하기
* findWinningCarPosition // 우승차 위치 찾기
* findWinningCars // 우승차들 고르기

## 4) Move
* createRandomValue //랜덤 값 생성하기
* checkMovable //n 이상 나오면 true 반환하기
* moveFoward //자동차 위치 변경하기

---
# < view >
## 1)  InputView
* inputCarsName //차 이름들 입력받기
* inputTrialCount //시도횟수 입력받기
## 2) OutputView
* outputTrialResult //시도결과 출력
* outputWinningCars //최종 우승자 출력
* createCarPositionLine //자동차 위치 선으로 만들기
