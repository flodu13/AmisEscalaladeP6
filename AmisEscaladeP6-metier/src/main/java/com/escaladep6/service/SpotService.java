package com.escaladep6.service;

import java.util.List;

import com.escaladep6.dao.SpotDao;
import com.escaladep6.entities.Spot;


public class SpotService {

	private static SpotService instance = new SpotService();

	private SpotDao spotDao = SpotDao.getInstance();

	private SpotService() {

	}

	public static SpotService getInstance() {
		return instance;
	}

	public List<Spot> findAll() {
		return spotDao.findAll();
	}
	
	public Spot getSpot(Integer idSpot) {
		return spotDao.getSpot(idSpot);
	}
	public List<Spot> findSpots(String region, String difficult, String name ) {
		return spotDao.findSpots(region, difficult, name);
	}
	
	public void  updateSpotTag(Spot newSpot, Integer idSpot ) {
		
		Spot old = spotDao.getSpot(idSpot);
		
		old.setTag(newSpot.getTag());

		spotDao.saveOrUpdateSpot(old);
		
	}
	
	public void addSpot(Spot spot) {
		spotDao.saveOrUpdateSpot(spot);
	}
	
}
