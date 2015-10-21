package member2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import global.Constants;
import global.DAO;
import global.DatabaseFactory;
import global.Vendor;

public class MemberDAO extends DAO{
	private Connection con;		// 패키지마다 필요하다 
	private Statement stmt;
	private ResultSet rs;
	private List<MemberVO> list= new ArrayList<MemberVO>();
	private MemberVO member = new MemberVO();
	
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance(){
		return instance;
	}
	public MemberDAO() {
		con = DatabaseFactory
				.getDatabase(Vendor.ORACLE, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD)
				.getConnection();
	}
	
	
	public int insert(MemberVO o) {
		int result = 0;
		try {
			stmt = con.createStatement();		// (오라클)커넥터에게 회원가입 양식지를 받는다.	
			rs = stmt.executeQuery(o.insert());
			if (rs != null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	public int update(MemberVO o) {
		int  result = 0;
		try {
			stmt=con.createStatement();
			rs = stmt.executeQuery(o.update());
			if (rs != null) {
				result =1;
			}
		} catch (SQLException e) {

		}
		System.out.println(result);
		return result;	
	}
	public List<MemberVO> selectSomeBy(String s1, String s2){
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(member.selectSomeBy(s1, s2));
			while (rs.next()) {
				MemberVO temp = new MemberVO();
				temp.setUserid(rs.getString("userid"));
				temp.setPassword(rs.getString("password"));
				temp.setName(rs.getString("name"));
				temp.setBirth(rs.getString("birth"));
				temp.setPhone(rs.getString("phone"));
				temp.setEmail(rs.getString("email"));
				temp.setGender(rs.getString("gender"));
				temp.setAddr(rs.getString("addr"));
				temp.setRegdate(rs.getString("regdate"));
				temp.setProfile(rs.getString("profile"));

				list.add(temp);				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}
	/**
	 * 객체가 생성/복사되는 것
	 * Account a = new Account(); = 생성 baby 출산
	 * List<> list = new ArrayList<>(); = 다형성 입양 -- Deep Copy 깊은 복사
	 * stmt = con.createStatement(); => 기능만 할당 -- Shallow Copy 얕은 복사
	 * 
	 */

	public List<MemberVO> selectAll() {
	
		try {
			stmt = con.createStatement();	//쿼리를 실행하는 객체
			rs = stmt.executeQuery(member.selectAll());
		//	rs = con.createStatement().executeQuery(member.selectAll());
			while (rs.next()) {
				MemberVO temp = new MemberVO();
				temp.setUserid(rs.getString("userid"));
				temp.setPassword(rs.getString("password"));
				temp.setName(rs.getString("name"));
				temp.setBirth(rs.getString("birth"));
				temp.setPhone(rs.getString("phone"));
				temp.setEmail(rs.getString("email"));
				temp.setGender(rs.getString("gender"));
				temp.setAddr(rs.getString("addr"));
				temp.setRegdate(rs.getString("regdate"));
				temp.setProfile(rs.getString("profile"));
//				System.out.println("회원정보: "+temp);

				list.add(temp);				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}


	public List<MemberVO> selectBy(String key) {
		try {
			stmt = con.createStatement();	//쿼리를 실행하는 객체
			rs = stmt.executeQuery(member.selectBy(key));
			while (rs.next()) {
				MemberVO temp = new MemberVO();
				temp.setUserid(rs.getString("userid"));
				temp.setPassword(rs.getString("password"));
				temp.setName(rs.getString("name"));
				temp.setBirth(rs.getString("birth"));
				temp.setPhone(rs.getString("phone"));
				temp.setEmail(rs.getString("email"));
				temp.setGender(rs.getString("gender"));
				temp.setAddr(rs.getString("addr"));
				temp.setRegdate(rs.getString("regdate"));
				temp.setProfile(rs.getString("profile"));
//				System.out.println("회원정보: "+temp);

				list.add(temp);				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MemberVO selectOneby(String key) {
		MemberVO temp = new MemberVO();
		try {
			stmt = con.createStatement();	//쿼리를 실행하는 객체
			rs = stmt.executeQuery(member.selectOneby(key));
			if (rs!=null) {
				while (rs.next()) {
					temp.setUserid(rs.getString("userid"));
					temp.setPassword(rs.getString("password"));
					temp.setName(rs.getString("name"));
					temp.setBirth(rs.getString("birth"));
					temp.setPhone(rs.getString("phone"));
					temp.setEmail(rs.getString("email"));
					temp.setGender(rs.getString("gender"));
					temp.setAddr(rs.getString("addr"));
					temp.setRegdate(rs.getString("regdate"));
					temp.setProfile(rs.getString("profile"));
				}
			} else {
				System.out.println("아이디 없음");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
		

	@Override
	public int count() {
		int temp = 0;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(member.count());
			while (rs.next()) {
				temp = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public int delete(String id) {
		int result = 0;
		try {
			stmt = con.createStatement();	//쿼리를 실행하는 객체
			rs = stmt.executeQuery(member.delete(id));
			if (rs != null) {
				result =1;
			}
		} catch (SQLException e) {

		}
		System.out.println(result);
		return result;	

	}
	public MemberVO login(String id, String pass) {
		MemberVO loginMember = new MemberVO();
		loginMember = this.selectOneby(id);
		if (loginMember.getUserid() == null) {
			return null;
		}
		if (loginMember.getPassword().equals(pass)) {
			return loginMember;
		} else {
			return null;
		}
	}

}	//Data Access Object


