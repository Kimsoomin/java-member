package score;

import java.util.ArrayList;
import java.util.List;

import member.MemberVO;
import member3.MemberService;
import member3.MemberServiceImpl;

public class ScoreServiceImpl implements ScoreService{
	private static ScoreService instance = new ScoreServiceImpl();
	public static ScoreService getInstance() {
		return instance;
	} 
	ScoreDAO dao = new ScoreDAO();
	
	@Override
	public String input(ScoreVO score) {
		String temp = "";
		if (dao.insert(score) == 1) {
			System.out.println("입력 완료");
		}else{
			System.out.println("실패");
		}
		System.out.println(score.toString());
		return temp;
	}		


	@Override
	public List<ScoreVO> getList() {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		list = dao.selectAll();
		return list;
	}

	@Override
	public ScoreVO searchByUserid(String userid) {
		ScoreVO m = new ScoreVO();
		m =dao.selectOneby(userid);	
		return m;
	}

	@Override
	public ScoreVO searchByName(String name) {
		ScoreVO m = new ScoreVO();
		m =dao.selectOneby(name);	
		return m;
	}

	@Override
	public void descByTotal() {

		
	}

	@Override
	public ArrayList<ScoreVO> ascByName() {
	
		return null;
	}

	@Override
	public void ascByTotal() {

		
	}

}
