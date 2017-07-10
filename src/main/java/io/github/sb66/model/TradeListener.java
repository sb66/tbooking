package io.github.sb66.model;

import io.github.sb66.repository.BookedTradeRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.persistence.PostPersist;

/**
 * Created by sbell on 05/07/2017.
 */
public class TradeListener {


    private static BookedTradeRepository bookedTradeRepository;

    public static void setBookedTradeRepository(BookedTradeRepository bookedTradeRepository) {
        TradeListener.bookedTradeRepository = bookedTradeRepository;
    }

    @PostPersist
    public synchronized void onPostPersist(Object o) {

        System.out.println("Persisted Trade "+o.toString());
        final Trade trade = (Trade)o;

        new Thread(new Runnable() {

            public void run() {
                BookedTrade bt = new BookedTrade(trade);
                bookedTradeRepository.save(bt);
                System.out.println("Booked Trade "+bt.toString());
            }
        }).start();
    }

}