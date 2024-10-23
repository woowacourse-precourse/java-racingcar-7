# java-racingcar-precourse
## 기능 정리
MVC 모델을 적용하고자 시도해뵈 위해 MVC별 기능을 정리해보려 한다.
### View (ViewScreen Class)
- 초기 입력 받기
- 경주 진행 화면 보여주기
- 우승자 보여주기

### Controller (ViewScreenController Class)
- 에러 처리(자동차 이름 글자수 체크)
- Model에게 View 정보 전달
- View에게 Model 결과 전달

### Model (Game Manager Class & Car Class)
#### Car Class
- 전진 할지말지 결정 및 저장

#### GameManager Class
- 자동차 리스트 생성
- 횟수만큼 경주 중 전진 진행
- 우승자 결정
- 다양한 에러 처리