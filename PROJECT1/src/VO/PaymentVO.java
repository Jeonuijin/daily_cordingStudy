package VO;

//amount 는 view 구현해서 변수로 주기로 함

public class PaymentVO {
	private int payment_id;
	private int payment_memid;
	private int payment_reid;
	private int payment_ticketcount;
	private int payment_price;
	private int tot_price;


	public PaymentVO(int payment_id, int payment_memid, int payment_reid, int payment_ticketcount,
			int payment_price) {
		super();
		this.payment_id = payment_id;
		this.payment_memid = payment_memid;
		this.payment_reid = payment_reid;
		this.payment_ticketcount = payment_ticketcount;
		this.payment_price = payment_price;
		TotalPrice();
	}

	public int getPayment_price() {
		return payment_price;
	}

	public void setPayment_price(int payment_price) {
		this.payment_price = payment_price;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getPayment_memid() {
		return payment_memid;
	}

	public void setPayment_memid(int payment_memid) {
		this.payment_memid = payment_memid;
	}

	public int getPayment_reid() {
		return payment_reid;
	}

	public void setPayment_reid(int payment_reid) {
		this.payment_reid = payment_reid;
	}

	public int getPayment_ticketcount() {
		return payment_ticketcount;
	}

	public void setPayment_ticketcount(int payment_ticketcount) {
		this.payment_ticketcount = payment_ticketcount;
	}

	
	@Override
	public String toString() {
		return "PaymentVO [payment_id=" + payment_id + ", payment_memid=" + payment_memid + ", payment_reid="
				+ payment_reid + ", payment_amount=" +  ", payment_ticketcount=" + payment_ticketcount
				+ ", payment_price=" + payment_price + ", tot_price=" + tot_price + "]";
	}
	
	public void TotalPrice() {
		tot_price = payment_price * payment_ticketcount;
		
	}
	
	
	
	
	
	
	
}
