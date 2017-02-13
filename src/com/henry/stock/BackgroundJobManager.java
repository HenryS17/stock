package com.henry.stock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BackgroundJobManager implements ServletContextListener {
	 private ScheduledExecutorService scheduler;
	 
	@Override
	public void contextInitialized(ServletContextEvent arg0) {		
		Long midnight=LocalDateTime.now().until(LocalDate.now().plusDays(1).atStartOfDay(), ChronoUnit.MINUTES) + 15;
		
		scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new UpdateValues(), midnight, 1440, TimeUnit.MINUTES);
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		scheduler.shutdownNow();		
	}
}
