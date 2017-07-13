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

    // number of trades to generate at startup
    private static int initialTrades=0;

    @Autowired
    private TradeRepository tradeRepository;

    public void setTradeRepository(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @Autowired
    private BookedTradeRepository bookedTradeRepository;

    public void setBookedTradeRepository(BookedTradeRepository bookedTradeRepository) {
        this.bookedTradeRepository = bookedTradeRepository;
    }


    @PostConstruct
    public void init() {
        TradeListener.setBookedTradeRepository(bookedTradeRepository);
        for (int n=0;n<initialTrades;n++ ) {
            Trade t = new Trade();
            t.setId("TRADE_MARKET_ABCD_"+n);
            t.setCounterParty("Cpty"+n);
            t.setFirmAccount("Firm"+n);
            t.setInstrument("inst"+n);
            t.setPrice(99.0);
            t.setQuantity(4.0);
            tradeRepository.save(t);
        }

    }

    public static void main(String[] args) {
        boolean argumentError=false;
        if (args.length>=1) {
            try {
                double probablilityFailed = Double.parseDouble(args[0]);
                BookedTrade.setProbabilityFailed(probablilityFailed);
            } catch (NumberFormatException e) {
                System.out.println("Double.parseDouble:"+e);
                argumentError=true;
            }
        }
        if (args.length>=2) {
            try {
                int tradeCount = Integer.parseInt(args[1]);
                initialTrades=tradeCount;
            } catch (NumberFormatException e) {
                System.out.println("Integer.parseInt:"+e);
                argumentError=true;
            }
        }
        if (argumentError) {
            System.out.println("usage: java -jar [-Dserver.port=8080] JARFILE [probabilityOfFailure (0.0-1.0)]  numberOfInitialTrades ");
        } else {
            SpringApplication.run(Application.class, args);
        }

	}

}
