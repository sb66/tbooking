package io.github.sb66.model;

import javax.persistence.*;

@Entity
public class BookedTrade {

	@Id
    @Column(columnDefinition="VARCHAR(100)")
	private String id;
	private String tradeId;

	private double price;
	private double quantity;
	private String instrument;
	private String firmAccount;
	private String counterParty;

	private String bookingStatus;

	public static double getProbabilityFailed() {
		return probabilityFailed;
	}

	public static void setProbabilityFailed(double probabilityFailed) {
		BookedTrade.probabilityFailed = probabilityFailed;
	}

	private static double probabilityFailed=0.0;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public String getFirmAccount() {
		return firmAccount;
	}

	public void setFirmAccount(String firmAccount) {
		this.firmAccount = firmAccount;
	}

	public String getCounterParty() {
		return counterParty;
	}

	public void setCounterParty(String counterParty) {
		this.counterParty = counterParty;
	}

    public BookedTrade() {}

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

 	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

//	@PrePersist
//	public void doPrePersist() {
//		this.id=this.tradeId;
//	}


	public BookedTrade(Trade trade) {
		setId(trade.getId());
	    setTradeId(trade.getTradeId());
		setPrice(trade.getPrice());
		setQuantity(trade.getQuantity());
		setInstrument(trade.getInstrument());
		setFirmAccount(trade.getFirmAccount());
		setCounterParty(trade.getCounterParty());
		if (Math.random()>probabilityFailed) {
			setBookingStatus("success");
		} else {
			setBookingStatus("failed");

		}
	}

	@Override
	public String toString() {
		return "BookedTrade{" +
				"tradeId='" + tradeId + '\'' +
				", id='" + id + '\'' +
				", price=" + price +
				", quantity=" + quantity +
				", instrument='" + instrument + '\'' +
				", firmAccount='" + firmAccount + '\'' +
				", counterParty='" + counterParty + '\'' +
				", bookingStatus='" + bookingStatus + '\'' +
				'}';
	}
}
