package score;

import java.util.Scanner;

public class ScoreMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ScoreService service = new ScoreServiceImpl();

		while (true) {
			System.out.println(
					"1:성적등록 2:학적부리스트보기 3:ID검색 4:이름으로검색 " + 
			"5:성적 상위순으로 순위출력 6:성적 하위순으로 순위출력(스왑) 7:이름 오름차순 출력  8:종료");

			switch (scanner.nextInt()) {
			case 1:
				System.out.println("아이디 입력");
				String input = scanner.next();
				if (service.searchByUserid(input).getUserid() == null) {
					System.out.println("존재하지 않습니다.");
					break;  
				}
				System.out.println("java, jsp, html, "
						+ "javascript, oracle, spring");
				ScoreVO score = new ScoreVO(input,scanner.nextInt(),scanner.nextInt()
						,scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
				System.out.println(service.input(score));
				break;
			case 2:
				System.out.println(service.getList());
				break;
			case 3:
				System.out.println("ID 검색");
				String userid = scanner.next();
				System.out.println(service.searchByUserid(userid));
				break;
			case 4:
				System.out.println("검색할 이름");
				String name = scanner.next();
				System.out.println(service.searchByName(name));
				break;
			case 5:
				service.descByTotal();
				System.out.println(service.getList());
				break;
			case 6:
				service.ascByTotal();
				System.out.println(service.getList());
				break;
			case 7:
				service.ascByName();
				System.out.println(service.getList());
				break;
			case 8:
				return;
			default:
				break;
			}
		}
	}
}