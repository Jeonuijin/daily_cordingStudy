package VO;

public class ReservationVO {
	private int re_id;
	private int re_memid;
	private int re_movid;
	private String re_sctime;
	private int re_scseat;
	
	public ReservationVO(int re_id, int re_memid, int re_movid, String re_sctime, int re_scseat) {
		super();
		this.re_id = re_id;
		this.re_memid = re_memid;
		this.re_movid = re_movid;
		this.re_sctime = re_sctime;
		this.re_scseat = re_scseat;
	}

	public int getRe_id() {
		return re_id;
	}

	public void setRe_id(int re_id) {
		this.re_id = re_id;
	}

	public int getRe_memid() {
		return re_memid;
	}

	public void setRe_memid(int re_memid) {
		this.re_memid = re_memid;
	}

	public int getRe_movid() {
		return re_movid;
	}

	public void setRe_movid(int re_movid) {
		this.re_movid = re_movid;
	}

	public String getRe_sctime() {
		return re_sctime;
	}

	public void setRe_sctime(String re_sctime) {
		this.re_sctime = re_sctime;
	}

	public int getRe_scseat() {
		return re_scseat;
	}

	public void setRe_scseat(int re_scseat) {
		this.re_scseat = re_scseat;
	}

	@Override
	public String toString() {
		return "ReservationVO [re_id=" + re_id + ", re_memid=" + re_memid + ", re_movid=" + re_movid + ", re_sctime="
				+ re_sctime + ", re_scseat=" + re_scseat + "]";
	}
	
	
	
	
}
