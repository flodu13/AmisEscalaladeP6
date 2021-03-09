package com.escaladep6.service;

import java.util.List;

import com.escaladep6.dao.PathDao;
import com.escaladep6.entities.Path;

public class PathService {
	
	private static PathService instance = new PathService();

	private PathDao pathDao = PathDao.getInstance();

	private PathService() {

	}

	public static PathService getInstance() {
		return instance;
	}

	public List<Path> findAll() {
		return pathDao.findAll();
	}
	public Path getPath(Long idPath) {
		return pathDao.getPath(idPath);
	}

	public void addPath(Path path) {
		pathDao.saveOrUpdatePath(path);
	}

}
