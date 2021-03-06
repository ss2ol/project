package com.meta.rec.controller;

import java.io.File;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.meta.rec.dto.FileVo;
import com.meta.rec.service.FileUploadService;

@Controller
public class DBFileController {

	@Autowired
	FileUploadService fileUploadService;

	@Autowired
	ServletContext servletContext;

	@GetMapping("/")
	public String main() {
		return "voice_save";
	}

	@ResponseBody
	@PostMapping("/dbupload")
	public String dbupload(@RequestParam("data") MultipartFile file) {
		try {
			if (file != null && !file.isEmpty()) {
				String path = servletContext.getRealPath("/fileupload/");
				FileVo fileVo = new FileVo();
				fileVo.setId(fileUploadService.getFileId());
				fileVo.setDirectory_name(path);
				fileVo.setName(file.getOriginalFilename());
				fileVo.setTsize(file.getSize());
				fileVo.setContent_type(file.getContentType());
				fileVo.setData(file.getBytes());
				// db저장
				fileUploadService.fileDBupload(fileVo);
				// 폴더 저장
				File upfile = new File(path + fileVo.getId());
				file.transferTo(upfile);
				return "녹음 저장";
			} else {
				return "비었음";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "녹음 실패";
		}
	}

	@GetMapping("/voice")
	public String voice() {
		return "voice_recive";
	}

	@ResponseBody
	@PostMapping("/voice")
	public void voice(@RequestParam("fileId") Integer fileId, HttpServletResponse response) {
		try {
			FileVo fileVo = fileUploadService.getFile(fileId);
			OutputStream out = response.getOutputStream();
			FileCopyUtils.copy(fileVo.getData(), out);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/voicep")
	public String voicep(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("id",id);
		return "voice_play";
	}

	@ResponseBody
	@GetMapping("/voice/{id}")
	public void voicep(@PathVariable Integer id , HttpServletResponse response) {
		try {
			FileVo fileVo = fileUploadService.getFile(id);
			OutputStream out = response.getOutputStream();
			FileCopyUtils.copy(fileVo.getData(), out);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
