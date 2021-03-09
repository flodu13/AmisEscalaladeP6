package com.escaladep6.service;

import java.util.List;

import com.escaladep6.dao.TopoDao;
import com.escaladep6.entities.Topo;


public class TopoService {
	
	private static TopoService instance = new TopoService();

	private TopoDao topoDao = TopoDao.getInstance();

	private TopoService() {

	}

	public static TopoService getInstance() {
		return instance;
	}

	public List<Topo> findAll() {
		return topoDao.findAll();
	}
	
	public Topo getTopoById(Integer idTopo) {
		return topoDao.getTopoById(idTopo);
	}
	public List<Topo> getTopoByUser (Integer idUser) {		 
		return topoDao.getTopoByUser(idUser);
		 }
	public List<Topo> findTopos(String location, String name, Boolean available) {
		return topoDao.findTopos(location, name, available);
	}
	
	
	public void addTopo(Topo topo) {		
		topoDao.saveOrUpdateTopo(topo);
	}	
	public void  updateTopoAvailability(Topo newTopo, Integer idTopo ) {
		
		Topo old = topoDao.getTopoById(idTopo);
		
		old.setAvailable(newTopo.getAvailable());

		topoDao.saveOrUpdateTopo(old);
		
	}

}
