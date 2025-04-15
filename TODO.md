# 요구사항 리스트  

## Domain

### Users (유저)
- [x] 검증 (빈 값 검증, 아이디 띄어쓰기, 한글 입력 시 예외)

### TodoCategory (Todo 대분류)
- [X] 검증 (빈 값)

### Todo 
- [x] 검증 (빈 값)


### Schedule (일정)
- [ ] 검증 (빈 값 검증)

## Service

### UserService
- [X] 회원 가입 시 이미 가입된 회원 이라면 예외
- [X] 회원 가입 완료 후 Users PK 반환 

### TodoCategoryService
- [X] 생성 테스트 (등록 완료 후 PK 반환, 없는 회원으로 접근 시 에러)

### TodoService
- [ ] 조회, 수정 삭제 중 유저의 Todo 아닐 시 예외


### ScheduleService
- [ ] 조회, 수정 삭제 중 유저의 할 일 아닐 시 예외

## Repository

### UsersRepository
- [X] 회원 가입, 로그인 시 필요한 유저 아이디로 도메인 찾기

### TodoCategoryRepository
- [X] 생성 후 Users와 연관관계 매핑 확인

### TodoRepository
- [ ] TodoCategory PK 리스트 IN 절로 Todo 리스트 반환

