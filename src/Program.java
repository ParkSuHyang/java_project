
class Program {
	public static void main(String[] args) {
		
		Subject[] subjects = new Subject[30];
		Open[] opens = new Open[30];

		Staff s = new Staff(90718, "staff");

		Professor p = new Professor(80718, "park", subjects, opens);
		Student stu = new Student(70718, "kim", opens);
		int subjects_cnt = 0;
		int opens_cnt = 0;
		int i;
		boolean flag = true;
		int menu;
		int select;
		while (flag) {
			Console.WriteLine("======== Main MENU ========");
			Console.WriteLine("|     1. 교직원           |");
			Console.WriteLine("|     2. 교수             |");
			Console.WriteLine("|     3. 학생             |");
			Console.WriteLine("|     4. 종료             |");
			Console.WriteLine("===========================");
			Console.Write("입력 >> ");
			menu = Int32.Parse(Console.ReadLine());

			switch (menu) {
			case 1:
				Console.Clear();
				Console.WriteLine("-------교직원 Menu---------");
				subjects_cnt = s.addSubject(subjects, subjects_cnt);
				break;
			case 2:
				Console.Clear();
				Console.WriteLine("--------교수 Menu---------");
				Console.WriteLine("|     1. 과목개설         |");
				Console.WriteLine("|     2. 과목수정         |");
				Console.WriteLine("|     3. 과목삭제         |");
				Console.WriteLine("|     4. 과목출력         |");
				Console.WriteLine("|     5. 돌아가기         |");
				Console.WriteLine("--------------------------");
				Console.Write("입력 >> ");
				select = Int32.Parse(Console.ReadLine());

				switch (select) {
				case 1:
					i = p.open(subjects_cnt, opens_cnt);
					if (i > 0) {
						opens_cnt = i;
					}
					break;
				case 2:
					p.editOpen(opens_cnt);
					break;
				case 3:
					i = p.delOpen(opens_cnt);
					if (i >= 0) {
						opens_cnt = i;
					}
					break;
				case 4:
					for (i = 0; i < opens_cnt; i++) {
						opens[i].print();
					}
					break;
				case 5:
					break;
				}
				break;
			case 3:
				Console.Clear();
				Console.WriteLine("--------학생 Menu----------");
				Console.WriteLine("|     1. 수강신청         |");
				Console.WriteLine("|     2. 과목삭제         |");
				Console.WriteLine("|     3. 출력             |");
				Console.WriteLine("|     4. 돌아가기         |");
				Console.WriteLine("---------------------------");
				Console.Write("입력 >> ");
				select = Int32.Parse(Console.ReadLine());
				switch (select) {
				case 1:
					stu.regist(opens_cnt);
					break;
				case 2:
					stu.cancel();
					break;
				case 3:

					Console.WriteLine("case3");
					stu.printMyList();
					break;
				case 4:
					break;
				}
				break;
			case 4:
				flag = false;
				break;
			}

		}
	}
}
