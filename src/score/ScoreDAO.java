package score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import global.Constants;
import global.DAO;
import global.DatabaseFactory;
import global.Vendor;
import member3.MemberDAO;
import member3.MemberVO;

public class ScoreDAO extends DAO{
	
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<ScoreVO> list = new ArrayList<ScoreVO>();
	private ScoreVO score = new ScoreVO();
	
	private static ScoreDAO instance = new ScoreDAO();
	
	public static ScoreDAO getInstance(){
		return instance;
	}
	public ScoreDAO() {
		con = DatabaseFactory
				.getDatabase(Vendor.ORACLE, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD)
				.getConnection();
	}
	
	// DML
	@Override
	public int insert(ScoreVO o) {
		int result = 0;
		try {
			pstmt = con.prepareStatement(o.insert());
			pstmt.setString(1, o.getUserid());
			pstmt.setInt(2, o.getJava());
			pstmt.setInt(3, o.getJsp());
			pstmt.setInt(4, o.getHtml());
			pstmt.setInt(5, o.getJavascript());
			pstmt.setInt(6, o.getOracle());
			pstmt.setInt(7, o.getSpring());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
		
	//DQL
	@Override
	public List selectAll() {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		try {
			stmt = con.createStatement(); // 쿼리를 실행하는 객체
			rs = stmt.executeQuery(score.selectAll());
		     
			while (rs.next()) {
				ScoreVO temp = new ScoreVO(); 
				temp.setScore_seq(rs.getInt("score_seq"));
				temp.setUserid(rs.getString("userid"));
				temp.setJava(rs.getInt("java"));
				temp.setJsp(rs.getInt("jsp"));
				temp.setHtml(rs.getInt("html"));
				temp.setJavascript(rs.getInt("javascript"));
				temp.setOracle(rs.getInt("oracle"));
				temp.setSpring(rs.getInt("spring"));

				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public ScoreVO selectOneby(String key) {
		ScoreVO temp = new ScoreVO();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(score.selectOneby(key));
			
			while (rs.next()) {
				temp.setScore_seq(rs.getInt("score_seq"));
				temp.setUserid(rs.getString("userid"));
				temp.setJava(rs.getInt("java"));
				temp.setJsp(rs.getInt("jsp"));
				temp.setHtml(rs.getInt("html"));
				temp.setJavascript(rs.getInt("javascript"));
				temp.setOracle(rs.getInt("oracle"));
				temp.setSpring(rs.getInt("spring"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}


	public List selectSomeBy(String s1,String s2){
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(score.selectSomeBy(s1, s2));
			while (rs.next()) {
				ScoreVO temp = new ScoreVO(); 
				temp.setScore_seq(rs.getInt("score_seq"));
				temp.setUserid(rs.getString("userid"));
				temp.setJava(rs.getInt("java"));
				temp.setJsp(rs.getInt("jsp"));
				temp.setHtml(rs.getInt("html"));
				temp.setJavascript(rs.getInt("javascript"));
				temp.setOracle(rs.getInt("oracle"));
				temp.setSpring(rs.getInt("spring"));

				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int count() {
		return 0;
	}

}
