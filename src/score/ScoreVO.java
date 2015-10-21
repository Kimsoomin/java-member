package score;

import java.io.Serializable;

import global.SQL;

public class ScoreVO implements SQL,Serializable{

	private static final long serialVersionUID = 1L;
	
	private int score_seq;
	private String userid;
	private int java;
	private int jsp;
	private int html;
	private int javascript;
	private int oracle;
	private int spring;
	
	public ScoreVO() {
		
	}
	
	public ScoreVO(String userid, int java, int jsp, int html, int javascript
			, int oracle, int spring) {
		this.userid = userid;
		this.java = java;
		this.jsp = jsp;
		this.html = html;
		this.javascript = javascript;
		this.oracle = oracle;
		this.spring = spring;
	}
	
	public int getScore_seq() {
		return score_seq;
	}

	public int getJava() {
		return java;
	}

	public int getJsp() {
		return jsp;
	}

	public int getHtml() {
		return html;
	}

	public int getJavascript() {
		return javascript;
	}

	public int getOracle() {
		return oracle;
	}

	public int getSpring() {
		return spring;
	}

	public String getUserid() {
		return userid;
	}

	public void setScore_seq(int score_seq) {
		this.score_seq = score_seq;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public void setJsp(int jsp) {
		this.jsp = jsp;
	}

	public void setHtml(int html) {
		this.html = html;
	}

	public void setJavascript(int javascript) {
		this.javascript = javascript;
	}

	public void setOracle(int oracle) {
		this.oracle = oracle;
	}

	public void setSpring(int spring) {
		this.spring = spring;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
	@Override
	public String toString() {
		return "회원 [시퀀스=" + this.score_seq
				+ ", 아이디=" + userid
				+ ", java점수=" + java
				+ ", jsp점수=" + jsp
				+ ", html점수=" + html
				+ ", javascript점수=" + javascript
				+ ", oracle점수=" + oracle
				+ ", spring점수=" + spring
				+ "]";
	}
	
	@Override
	public String insert() {
		String query = "insert into score "
				+ "(score_seq, userid, java, jsp, html, javascript, "
				+ "oracle, spring)values(score_seq.nextval,?,?,?,?,?,?,?)";
		return query;
	}

	@Override
	public String update() {
		String query = "update score"
				+" set java = ?,"
				+ "addr = ?"
				+ "where userid = ?";
		return query;
	}

	@Override
	public String delete(String s) {

		return null;
	}

	@Override
	public String selectAll() {
		String query = "select * from score";
		return query;
	}

	@Override
	public String selectOneby(String s) {
		String query = "select * from score where userid ="+this.make(s);
		return query;
	}

	@Override
	public String count() {
		String query = "select count(*) as count from score";
		return query;
	}

	@Override
	public String selectBy(String s) {
	
		return null;
	}

	@Override
	public String selectSomeBy(String s1, String s2) {
		String query = "select * from score where "+s1+" ="+this.make(s2);
		return query;
	}

	@Override
	public String make(String s) {
		return "'"+s+"'";
	}
	public int getTotal(){
		return 0;
	}

}
