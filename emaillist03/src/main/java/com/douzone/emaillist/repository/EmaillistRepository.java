package com.douzone.emaillist.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.douzone.emaillist.vo.EmaillistVo;

@Repository
public class EmaillistRepository {
	
	public List<EmaillistVo> findAll() {
		// TODO Auto-generated method stub
		List<EmaillistVo> result = new ArrayList<EmaillistVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			//3. SQL 준비
			String sql = "select no, first_name, last_name, email from emaillist order by no desc";
			pstmt = conn.prepareStatement(sql);
			
			//insert, update, delete 문 == executeUpdate
			//결과 값이 int
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				
				EmaillistVo vo = new EmaillistVo();
				vo.setNo(no);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setEmail(email);
				
				result.add(vo);
			}

		}catch(SQLException e) {
			System.out.println("error : "+e);
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();					
				}
				if(conn != null) {
					conn.close();					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}// end try ~ finally
		return result;
	}

	
	public boolean insert(EmaillistVo vo) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			//3. SQL 준비
			String sql = "insert into emaillist values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩(binding)
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3,vo.getEmail());
			//insert, update, delete 문 == executeUpdate
			//결과 값이 int
			int count = pstmt.executeUpdate();
			
			result = count == 1;
		}catch(SQLException e) {
			System.out.println("error : "+e);
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();					
				}
				if(conn != null) {
					conn.close();					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}// end try ~ finally
		return result;
	}//end insert
	
	//Connection
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			//2. 연결하기
			//   연결 url 필요
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf-8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
//			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패 : "+e);
		}

		return conn;
	}// end Connection
}
