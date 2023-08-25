package VO;

public class ScreeningVO {
	private String sc_time;
	private int sc_seat;
	private int sc_movid;
	
	public ScreeningVO(String sc_time, int sc_seat, int sc_movid) {
		super();
		this.sc_time = sc_time;
		this.sc_seat = sc_seat;
		this.sc_movid = sc_movid;
	}

	public String getSc_time() {
		return sc_time;
	}

	public void setSc_time(String sc_time) {
		this.sc_time = sc_time;
	}

	public int getSc_seat() {
		return sc_seat;
	}

	public void setSc_seat(int sc_seat) {
		this.sc_seat = sc_seat;
	}

	public int getSc_movid() {
		return sc_movid;
	}

	public void setSc_movid(int sc_movid) {
		this.sc_movid = sc_movid;
	}

	@Override
	public String toString() {
		return "ScreeningVO [sc_time=" + sc_time + ", sc_seat=" + sc_seat + ", sc_movid=" + sc_movid + "]";
	}
	
	
	
	
	
	
}
