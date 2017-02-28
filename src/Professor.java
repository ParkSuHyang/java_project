class Professor {
	private int num;
	private String name;
	private Subject[] subjects;
	private Open[] opens;

	public Professor(int num, String name, Subject[] sub, Open[] o) {
		this.num = num;
		this.name = name;
		subjects = sub;
		opens = o;
	}

	public void printSubStatFalse(int subjects_cnt) {
		int i;
		for (i = 0; i < subjects_cnt; i++) {
			if (subjects[i].state == false) {
				subjects[i].print();
			}
		}
	}

	public int open(int subjects_cnt, int opens_cnt) {
		int i;
		Subject sub = null;

		Console.WriteLine("");
		Console.WriteLine("===========������ ����============");
		printSubStatFalse(subjects_cnt);
		Console.Write("���� �����ڵ� : ");
		int code = Int32.Parse(Console.ReadLine());

		for (i = 0; i < subjects_cnt; i++) {
			if (code == subjects[i].get_code()) {
				if (subjects[i].state == true) {
					Console.WriteLine("�̹� ������ �����ڵ�");
					return -1;
				}
				sub = subjects[i];
				break;
			}
		}
		if (i == subjects_cnt) {
			Console.WriteLine("�߸��� �����ڵ�");
			return -1;
		}

		Console.Write("���ǽ� : ");
		String room = Console.ReadLine();
		Console.Write("���� : ");
		String day = Console.ReadLine();
		Console.Write("�ð� : ");
		String time = Console.ReadLine();
		Console.Write("�ο��� : ");
		int cnt = Int32.Parse(Console.ReadLine());
		opens[opens_cnt++] = new Open(sub, room, day, time, cnt, num);
		sub.state = true;
		return opens_cnt;
	}

	public int searchOpen(int code, int opens_cnt) {
		int i;
		for (i = 0; i < opens_cnt; i++) {
			if (code == opens[i].getS().get_code()) {
				return i;
			}
		}
		return -1;
	}

	public void myOpens(int opens_cnt) {
		int i;
		for (i = 0; i < opens_cnt; i++) {
			if (num == opens[i].getProfNum()) {
				opens[i].print();
			}
		}
	}

	public void editOpen(int opens_cnt) {
		int idx = -1, code = 0;
		myOpens(opens_cnt);
		Console.Write("������ ������ �ڵ� : ");
		code = Int32.Parse(Console.ReadLine());
		idx = searchOpen(code, opens_cnt);

		if (idx < 0 || num != opens[idx].getProfNum()) {
			return;
		}

		Console.Write("new ���ǽ� : ");
		opens[idx].setRoom(Console.ReadLine());
		Console.Write("new ���� : ");
		opens[idx].setDay(Console.ReadLine());
		Console.Write("new �ð� : ");
		opens[idx].setTime(Console.ReadLine());
		Console.Write("new �ο��� : ");
		opens[idx].setCnt(Int32.Parse(Console.ReadLine()));
	}

	public int delOpen(int opens_cnt) {
		int idx = -1, code = 0, i;
		myOpens(opens_cnt);
		Console.Write("������ ������ �ڵ� : ");
		code = Int32.Parse(Console.ReadLine());

		idx = searchOpen(code, opens_cnt);

		if (idx < 0 || num != opens[idx].getProfNum()) {
			return -1;
		}
		for (i = idx; i < opens_cnt - 1; i++) {
			opens[i] = opens[i + 1];
		}
		return --opens_cnt;
	}

}
