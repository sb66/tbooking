package io.github.sb66;

import io.github.sb66.model.BookedTrade;
import io.github.sb66.model.Trade;
import io.github.sb66.model.TradeListener;
import io.github.sb66.repository.BookedTradeRepository;
import io.github.sb66.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Autowired
    private TradeRepository tradeRepository;

    public void setBookedTradeRepository(BookedTradeRepository bookedTradeRepository) {
        this.bookedTradeRepository = bookedTradeRepository;
    }

    @Autowired
    private BookedTradeRepository bookedTradeRepository;

    public void setTradeRepository(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }


    @PostConstruct
    public void init() {
        TradeListener.setBookedTradeRepository(bookedTradeRepository);
        for (int n=0;n<10;n++ ) {
            Trade t = new Trade();
            t.setId("TRADE_MARKET_ABCD_"+n);
//            t.setTradeId("TRADE_MARKET_ABCD_"+n);
            t.setCounterParty("Cpty"+n);
            t.setFirmAccount("Firm"+n);
            t.setInstrument("inst"+n);
            t.setPrice(99.0);
            t.setQuantity(4.0);
            tradeRepository.save(t);
        }

    }

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
