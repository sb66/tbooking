package io.github.sb66.model;

import javax.persistence.*;

@Entity  @EntityListeners(TradeListener.class)
public class Trade {


	@Id
    @Column(columnDefinition="VARCHAR(100)")
	private String id;
	private String tradeId;

	private double price;
	private double quantity;
	private String instrument;
	private String firmAccount;
	private String counterParty;


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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTradeId() {
        return tradeId;
    }

    private void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

	@PrePersist
	public void onPrePersist() {
		setTradeId(getId());
	}

	@Override
	public String toString() {
		return "Trade{" +
				"tradeId='" + tradeId + '\'' +
				", price=" + price +
				", quantity=" + quantity +
				", instrument='" + instrument + '\'' +
				", firmAccount='" + firmAccount + '\'' +
				", counterParty='" + counterParty + '\'' +
				'}';
	}

}