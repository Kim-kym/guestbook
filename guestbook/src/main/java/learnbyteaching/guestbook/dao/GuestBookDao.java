package learnbyteaching.guestbook.dao;

import java.util.List;

import learnbyteaching.guestbook.vo.BookVo;

// interface 
// 구체적인 동작(코드)은 정의하지 않고 
// 기능의 약속(틀)만 정의 
// 다른 클래스가 실제 동작 구현 

public interface GuestBookDao {
	// 데이터베이스에서 모든 도서 데이터를 가져오는 기능 정의
	// List: 여러 개의 데이터를 저장하는 자료 구조 
	// BookVo: 도서 데이터를 담는 하나의 객체
	public List<BookVo> getList();
	// 새로운 도서 데이터를 데이터베이스에 추가하는 기능 정의
	// boolean: 데이터 삽입이 성공하면 true, 실패하면 false 반환 
	public boolean insert(BookVo vo);
	// 특정 도서 데이터를 데이터베이스에서 삭제하는 기능 정의
	// Long no: 삭제할 도서 데이터의 고유 ID(번호) 
	// boolean: 데이터 삽입이 성공하면 true, 실패하면 false 반환 
	public boolean delete(Integer no, String password);

	
	

}
