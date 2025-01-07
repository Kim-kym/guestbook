package learnbyteaching.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// abstract: 추상 클래스
// 직접 객체를 만들 수 없으며,
// 다른 클래스가 상속받아 기능을 확장하거나 구현 
// 공통적인 데이터베이스 작업을 처리하기 위해 만들어짐 

public abstract class BaseDao {
	// 데이터베이스 사용자 이름과 비밀번호를 저장하는 변수
	private String dbUser = null; 
	private String dbPass = null;
	
	// 생성자
	// 초기화 역할 
	public BaseDao(String dbUser, String dbPass) {
		this.dbUser = dbUser;
		this.dbPass = dbPass;
	}
	
	// Connection: 데이터베이스와 연결을 나타내는 객체 
	protected Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			// Jdbc.Driver: MySQL 데이터베이스와 Java가 통신할 수 있게 도와줌 
			// Jdbc.Dirver를 메모리에 로드 
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 데이터베이스 연결 
			String dburl = "jdbc:mysql://localhost:3306/webdb";
			// dburl, dbUser, dbPass를 사용하여 MYSSQL 드라이버에 연결
			// 성공하면 conn 객체 반환
			conn = DriverManager.getConnection(dburl, dbUser, dbPass);		
		} catch (ClassNotFoundException e) { //	예외 처리
			System.err.println("JDBC Driver를 로드하지 못했습니다.");
			e.printStackTrace();
		}
		// 데이터베이스 연결 객체(conn)를 호출한 쪽으로 반환 
		return conn;
	}
}
