package score;

import java.util.Comparator;

public class DescTotal implements Comparator<ScoreVO> {

	@Override
	public int compare(ScoreVO front, ScoreVO back) {

		return (front.getTotal() > back.getTotal()) ? -1 : front.getTotal() < back.getTotal() ? 1 : 0;

		/**
		 * 삼항 연산자 (컨디션) ? -1 : (거짓이라면 다시 컨디션을 주고) ? true : false ;
		 */
	}

}
