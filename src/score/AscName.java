package score;

import java.util.Comparator;

public class AscName implements Comparator<ScoreVO>{

	@Override
	public int compare(ScoreVO front, ScoreVO back) {
		
		return front.getUserid().compareTo(back.getUserid());

	}
	
}