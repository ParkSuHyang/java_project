class Student {
	private int num;
	private String name;
	private Open[] opens;
	private Open[] myList;
	private int myCnt;

	public Student(int num, String name, Open[] opens) {
		this.num = num;
		this.name = name;
		this.opens = opens;
		myList = new Open[10];
		myCnt = 0;
	}

	public void openList(int opens_cnt) {
		int i;
		for (i = 0; i < opens_cnt; i++) {
			opens[i].print();
		}
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

	public void regist(int opens_cnt) {
		openList(opens_cnt);
		Console.Write("수강신청할 과목코드 : ");
		int code = Int32.Parse(Console.ReadLine());
		boolean flag = dubCheck(code);

		if (!flag) {
			Console.WriteLine("이미 신청한 과목");
			return;
		}

		int idx = searchOpen(code, opens_cnt);

		if (idx < 0) {
			Console.WriteLine("잘못된 과목코드");
		} else {
			if (opens[idx].addCurCnt()) {
				myList[myCnt++] = opens[idx];
				Console.WriteLine("수강신청 성공!");
			} else {
				Console.WriteLine("인원초과");
			}
		}
	}

	public boolean dubCheck(int code) {
		int i;
		for (i = 0; i < myCnt; i++) {
			if (myList[i].getS().get_code() == code) {
				return false;
			}
		}
		return true;
	}

	public void printMyList() {
		int i;
		for (i = 0; i < myCnt; i++) {
			myList[i].print();
		}
	}

	public void cancel() {
		int i, idx;
		printMyList();
		Console.Write("취소할 과목코드 : ");
		int code = Int32.Parse(Console.ReadLine());

		for (i = 0; i < myCnt; i++) {
			if (myList[i].getS().get_code() == code) {
				myList[i].subCurCnt();
				break;
			}
		}

		if (i != myCnt) {
			for (idx = i; idx < i - 1; idx++) {
				myList[idx] = myList[idx + 1];
			}
			myCnt--;
		} else
			Console.Write("존재하지 않는 과목코드 입력!");
	}
}
