package com.neuedu.web;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadUtils {
	private static final String uploadPath = "/prodata/uploads/";

	@RequestMapping(value = "upload.action",produces="application/json;charset=utf-8")
	@ResponseBody
	public responsejson upload(HttpServletRequest request, MultipartFile file) throws Exception {
		String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		Path filepath = Paths.get(request.getServletContext().getRealPath("/")).getParent().resolve("prodata/uploads");
		System.out.println(filename);
		System.out.println(filepath.resolve(filename).toString());
		file.transferTo(Files.createFile(filepath.resolve(filename)).toFile());

		responsejson res = new responsejson();	
		res.setData(filename);
		res.setCode(0);
		res.setMessage("上传成功");
		return res;

	}

	@RequestMapping(value = "uploadfile.action",produces="application/json;charset=utf-8")
	@ResponseBody
	public responsejson uploadfile(HttpServletRequest request, MultipartFile file) throws Exception {
		String filename = null;
		if (!file.isEmpty()) {
			filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
			Path filepath = Paths.get(request.getServletContext().getRealPath("/")).getParent().resolve("prodata/uploads");
			System.out.println(filename);
			System.out.println(filepath.resolve(filename).toString());
			file.transferTo(Files.createFile(filepath.resolve(filename)).toFile());
		}
		responsejson res = new responsejson();
		res.setData(filename);
		res.setCode(0);
		res.setMessage("上传成功");
		return res;
	}

	@RequestMapping(value = "uploadedit.action",produces="application/json;charset=utf-8")
	@ResponseBody
	public String uploadedit (HttpServletRequest request, MultipartFile file) throws Exception {
		String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		Path filepath = Paths.get(request.getServletContext().getRealPath("/"))
				.getParent()
				.resolve("prodata/uploads");
		System.out.println(filename);
		System.out.println(filepath.resolve(filename).toString());
		file.transferTo(Files.createFile(filepath.resolve(filename)).toFile());
		editorreturn res=new editorreturn();
		res.setData(uploadPath + filename);
		res.setCode(0);
		res.setMessage("上传成功");
		System.out.println(JsonUtils.ObjectToJson(res));
		return JsonUtils.ObjectToJson(res);
		
	}
}
