package learnbyteaching.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import learnbyteaching.guestbook.vo.BookVo;

// 도서 데이터베이스와 상호작용
// BaseDao 상속 
// GuestBookDao 인터페이스 구현 
public class GuestBookDaoImpl
	extends BaseDao
	implements GuestBookDao {
	
	//	Constructor
	//	dbUser, dbPass를 받아서 부모(BaseDao)에 전달
	//	부모 클래스는 이 정보를 사용해 데이터베이스에 연결 
	public GuestBookDaoImpl(String dbUser, String dbPass) {
		super(dbUser, dbPass);
	}
	@Override
	// 데이터베이스에서 모든 도서 데이터를 가져와서 리스트로 반환 
	public List<BookVo> getList() {
		List<BookVo> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		try {
			conn = getConnection();
			String sql = "SELET no, last_name, first_name, email, created_at " +
					"FROM guestbook ORDER BY created_at DESC";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// rs.next(): 결과 데이터를 한 줄씩 읽어오기 
			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String content = rs.getString(4); 
				Date reg_date = rs.getDate(5); 
				
				// 도서 데이터를 담는 객체 
				BookVo info = new BookVo(no,
						name,
						password,
						content,
						reg_date);
				// 리스트에 도서 데이터 추가 
				list.add(info);
				}
			} catch (Exception e) {
				System.err.println("ERROR:" + e.getMessage());
			} finally {
				try { // 메모리 누수 방지 
					if (rs != null) rs.close();
					if (stmt != null) stmt.close();
					if (conn != null) conn.close();
				} catch (SQLException e) {
					System.err.println("ERROR:" + e.getMessage());
				}
			}
			return list; 
		}
	// 데이터베이스에 새로운 도서 데이터 추가 
	// 성공하면 true, 실패하면 false 
	@Override 
	public boolean insert(BookVo vo) {
		int insertedCount = 0; 
		
		Connection conn = null;
		PreparedStatement pstmt = null; 
		
		try { 
			conn = getConnection(); 
			
			String sql = "INSERT INTO emaillist " +
					"(name, password, content) " + 
					"VALUES (?, ?, ?)"; 
			// pstmt: 나중에 설정할 값
			// executeUpdate: 쿼리 실행 및 반환
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  vo.getName());
			pstmt.setString(2,  vo.getPassword());
			pstmt.setString(3, vo.getContent());
			insertedCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("ERROR:" + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.err.println("ERROR:" + e.getMessage());
			}
		}
		// 영향을 받은 행이 1개라면 성공(true), 실패면(false)
		return 1 == insertedCount;
	}
	
	//  특정 번호의 도서 데이터 삭제 
	@Override 
	public boolean delete(Long no) {
		int deletedCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM guestbook WHERE no=?";
			// 삭제하려는 데이터의 번호(no) 설정 
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			deletedCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.err.println("ERROR:" + e.getMessage());
			}
		}
		return 1 == deletedCount;
	}

}
