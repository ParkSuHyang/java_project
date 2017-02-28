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
		Console.WriteLine("===========개설된 과목============");
		printSubStatFalse(subjects_cnt);
		Console.Write("개설 과목코드 : ");
		int code = Int32.Parse(Console.ReadLine());

		for (i = 0; i < subjects_cnt; i++) {
			if (code == subjects[i].get_code()) {
				if (subjects[i].state == true) {
					Console.WriteLine("이미 개설된 과목코드");
					return -1;
				}
				sub = subjects[i];
				break;
			}
		}
		if (i == subjects_cnt) {
			Console.WriteLine("잘못된 과목코드");
			return -1;
		}

		Console.Write("강의실 : ");
		String room = Console.ReadLine();
		Console.Write("요일 : ");
		String day = Console.ReadLine();
		Console.Write("시간 : ");
		String time = Console.ReadLine();
		Console.Write("인원수 : ");
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
		Console.Write("수정할 과목의 코드 : ");
		code = Int32.Parse(Console.ReadLine());
		idx = searchOpen(code, opens_cnt);

		if (idx < 0 || num != opens[idx].getProfNum()) {
			return;
		}

		Console.Write("new 강의실 : ");
		opens[idx].setRoom(Console.ReadLine());
		Console.Write("new 요일 : ");
		opens[idx].setDay(Console.ReadLine());
		Console.Write("new 시간 : ");
		opens[idx].setTime(Console.ReadLine());
		Console.Write("new 인원수 : ");
		opens[idx].setCnt(Int32.Parse(Console.ReadLine()));
	}

	public int delOpen(int opens_cnt) {
		int idx = -1, code = 0, i;
		myOpens(opens_cnt);
		Console.Write("삭제할 과목의 코드 : ");
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
