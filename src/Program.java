
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
			Console.WriteLine("|     1. ������           |");
			Console.WriteLine("|     2. ����             |");
			Console.WriteLine("|     3. �л�             |");
			Console.WriteLine("|     4. ����             |");
			Console.WriteLine("===========================");
			Console.Write("�Է� >> ");
			menu = Int32.Parse(Console.ReadLine());

			switch (menu) {
			case 1:
				Console.Clear();
				Console.WriteLine("-------������ Menu---------");
				subjects_cnt = s.addSubject(subjects, subjects_cnt);
				break;
			case 2:
				Console.Clear();
				Console.WriteLine("--------���� Menu---------");
				Console.WriteLine("|     1. ���񰳼�         |");
				Console.WriteLine("|     2. �������         |");
				Console.WriteLine("|     3. �������         |");
				Console.WriteLine("|     4. �������         |");
				Console.WriteLine("|     5. ���ư���         |");
				Console.WriteLine("--------------------------");
				Console.Write("�Է� >> ");
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
				Console.WriteLine("--------�л� Menu----------");
				Console.WriteLine("|     1. ������û         |");
				Console.WriteLine("|     2. �������         |");
				Console.WriteLine("|     3. ���             |");
				Console.WriteLine("|     4. ���ư���         |");
				Console.WriteLine("---------------------------");
				Console.Write("�Է� >> ");
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
