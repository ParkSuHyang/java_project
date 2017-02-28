class Staff {
	private int num;
	private String name;

	public Staff(int num, String name) {
		this.num = num;
		this.name = name;
	}

	public int addSubject(Subject[] subjects, int sub_cnt) {
		int i;
		boolean flag = true;
		int code = 0;
		String name;

		while (flag) {
			Console.Write("과목코드 : ");
			code = Int32.Parse(Console.ReadLine());
			for (i = 0; i < sub_cnt; i++) {
				if (subjects[i].get_code() == code) {
					break;
				}
			}
			if (i == sub_cnt)
				flag = false;
		}
		Console.Write("과목이름 : ");
		name = Console.ReadLine();
		subjects[sub_cnt++] = new Subject(code, name);
		return sub_cnt;
	}
}
