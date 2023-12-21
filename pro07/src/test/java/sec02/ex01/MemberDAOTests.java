package sec02.ex01;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import sec02.ex02.MemberDAO;


class MemberDAOTests {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetConnection() {
		MemberDAO memberDAO = MemberDAO.getInstance();
		Connection conn = memberDAO.getConnection();
		System.out.println("conn: " + conn);
	}

}
