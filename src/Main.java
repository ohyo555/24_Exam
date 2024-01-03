import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

//	private static final String String = null;

	public static void main(String[] args) {
		
		System.out.println("== 명언 앱 실행 ==");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("명령어 ) ");
		
		String cmd = sc.nextLine();
		
		List<wiseSaying> wisesayings = new ArrayList<>();
		
		int id = 0;
		
		LocalDateTime now = LocalDateTime.now(); // 날짜, 시간 알려주는 애
		String formatNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		while (true) {
			if (cmd.equals("등록")) {
				
				System.out.print("명언 : ");
				String wisesaying = sc.nextLine();
				System.out.print("작가 : ");
				String author = sc.nextLine();
				
				String time = formatNow; // 저장할때 시간알려줘야하니까
				
				wiseSaying wisesaying1 = new wiseSaying(id, wisesaying, author, time);
				
				id++;
				wisesayings.add(wisesaying1);
				
				System.out.printf("%d번 명언이 등록되었습니다.\n",id);
				continue;

			} else if (cmd.equals("목록")) {
				
				System.out.println("번호  /  작가  /  명언  ");
				System.out.println("=".repeat(20));
				
				for (int i = wisesayings.size() - 1; i >= 0; i--) {
					wiseSaying wisesaying = wisesayings.get(i);
					System.out.printf("%d  /  %s  /  %s  ",wisesaying.getId(),wisesaying.getWisesaying(),wisesaying.getAuthor());
				}
				
			} else if (cmd.startsWith("수정")) {
				
//				split();
				
				String[] cmdBits = cmd.split("?",2);
				
				String action = cmdBits[0]; // 수정, 상세보기, 삭제
				
				Map<String,String> map = new HashMap<>(); // id를 키로 주고 해당하는 값은 vaule로 줄라고 map으로 만듬
				
				String[] x = cmdBits[1].split("=",2);
				
				String key = x[0];
				String value = x[1];
				
				map.put(key, value);
				
				boolean findByid = false;
				// 
				for (wiseSaying w : wisesayings) {
					if (w.getId() == id) {
						System.out.printf("명언(기존) : %s\n", w.getWisesaying());
						System.out.printf("작가(기존) : %s\n", w.getAuthor());
						System.out.print("명언 : ");
						String wisesaying = sc.nextLine();
						System.out.print("작가 : ");
						String author = sc.nextLine();
						
						w.setWisesaying(wisesaying);
						w.setAuthor(author);
						
						findByid = true;
						break;
					}
				} 
				
				if (findByid == false) {
					System.out.printf("%d번 명언은 존재하지 않습니다.",value);
				}
			} else if (cmd.startsWith("상세보기")) {
				// 얘도 수정에서 cmd 나눠주는거 동일하고 위에 날짜 포맷에 맞춰준거까지 나오게해
				// 날짜 저장
			} else if (cmd.startsWith("삭제")) {
				// x[1]이 wisesayings.getId에 있으면 object로 삭제
			}
			
		}
		
	}

//	private static void split() { // split 해주는 함수를 만들어서 수정, 상세보기, 삭제에 쓰려고 함
//		String[] cmdBits = cmd.split("?",2);
//		
//		String action = cmdBits[0]; // 수정, 상세보기, 삭제
//		
//		Map<String,String> map = new HashMap<>(); // id를 키로 주고 해당하는 값은 vaule로 줄라고 map으로 만듬
//		
//		String[] x = cmdBits[1].split("=",2);
//		
//		String key = x[0];
//		String value = x[1];
//		
//		map.put(key, value);
//	}

}
