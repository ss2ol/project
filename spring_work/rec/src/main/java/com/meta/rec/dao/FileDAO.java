package com.meta.rec.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.meta.rec.dto.FileVo;

@Mapper
@Repository
public interface FileDAO {
	Integer maxFileId() throws SQLException;

	FileVo selectFile(int id) throws SQLException;

	void insertFile(FileVo filevo) throws SQLException;

}
