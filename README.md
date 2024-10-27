## 요구 사항 분석
<hr>

- 자동차는 전진 또는 정지한다
- 자동차에 이름이 존재한다  
  - 이름은 5자 이하  
  - 공백은 불가, 콤마로 구분  
  - 0~9 사이 무작위 값을 구 후 4이상이면 전진한다, 그 외는 정지
- 매 라운드 마다의 결과를 출력한다
- 경주 완료 후 우승자를 출력한다. (우승자 한명 이상 가능)

## 기능 구현 목록
<hr>

- [x] 자동차 이동    
  - [x] 경주 기능      
  - [x] 0~9 사이 무작위 값을 구 후 4이상이면 전진한다
- [ ] 입력    
  - [x] 몇 번 이동할 것인지 입력    
  - [x] 자동차 이름 입력    
  - [ ] 입력에 대한 검증      
    - [ ] 자동차는 한 대 이상 입력한다(이름이 공백일 경우 다시 입력한다) 
    - [x] 이름이 6자 이상일 경우 예외 처리
- [x] 출력
  - [x] 실행 문구 출력  
  - [x] 매 라운드 결과 출력  
  - [x] 경주 완료 후 우승자를 출력한다. (우승자 한명 이상 가능)