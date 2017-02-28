
class Open {
	private int profNum;
	private Subject s;
	private String room;
	private String day;
	private String time;
	private int cnt;
	private int curCnt;

	public Open() {

	}

	public Open(Subject s, String room, String day, String time, int cnt, int pn) {
		this.s = s;
		this.room = room;
		this.day = day;
		this.time = time;
		this.cnt = cnt;
		profNum = pn;
	}

	public int getProfNum() {
		return profNum;
	}

	public void setS(Subject s) {
		this.s = s;
	}

	public Subject getS() {
		return s;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getRoom() {
		return room;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDay() {
		return day;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getCnt() {
		return cnt;
	}

	public boolean addCurCnt() {
		if (cnt <= curCnt)
			return false;
		else
			curCnt++;
		return true;
	}

	public int getCurCnt() {
		return curCnt;
	}

	public void subCurCnt() {
		curCnt--;
	}

	public void print() {
		s.print();
		Console.WriteLine("room : {0}", room);
		Console.WriteLine("day : {0}", day);
		Console.WriteLine("time : {0}", time);
		Console.WriteLine("현재인원/인원 : {0}/{1}", curCnt, cnt);
	}
}
