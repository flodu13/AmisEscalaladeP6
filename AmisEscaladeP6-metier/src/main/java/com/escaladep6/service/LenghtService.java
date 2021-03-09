package com.escaladep6.service;

import java.util.List;

import com.escaladep6.dao.LenghtDao;
import com.escaladep6.entities.Lenght;


public class LenghtService {
	
	private static LenghtService instance = new LenghtService();

	private LenghtDao lenghtDao = LenghtDao.getInstance();

	private LenghtService() {

	}

	public static LenghtService getInstance() {
		return instance;
	}

	public List<Lenght> findAll() {
		return lenghtDao.findAll();
	}
	public Lenght getLenght(Long idLenght) {
		return lenghtDao.getLenght(idLenght);
	}

	public void addLenght(Lenght lenght) {
		lenghtDao.saveOrUpdateLenght(lenght);
	}

}
