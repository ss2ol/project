package com.meta.rec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meta.rec.dao.FileDAO;
import com.meta.rec.dto.FileVo;

@Service
public class FileUploadService {
	
	@Autowired
	FileDAO fileDAO;

	public void fileDBupload(FileVo fileVo) throws Exception{
		fileDAO.insertFile(fileVo);
	}
	
	
	public int getFileId() throws Exception{
		Integer id = fileDAO.maxFileId();
		if(id == null) id =0;
		return id+1;
	}
	
	   public FileVo getFile(int id) throws Exception {
		      return fileDAO.selectFile(id);
}
}