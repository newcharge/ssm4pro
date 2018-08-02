package com.neuedu.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadUtils {
	@RequestMapping(value = "/upload.action")
	@ResponseBody
	public responsejson upload (HttpServletRequest request, MultipartFile file) throws Exception {
		String pathOfService = request.getServletContext().getRealPath("/");
		String path;
		//System.out.println(file.getOriginalFilename());
		path =  (new Date().getTime()) + file.getOriginalFilename();
		System.out.println(pathOfService + path);
		String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		String filepath=pathOfService + path;
		File files=new File(pathOfService + path);
		file.transferTo(files);
		responsejson res=new responsejson();
		res.setData(path);
		res.setCode(0);
		res.setMessage("上传成功");
		return res;
		
	}
}
