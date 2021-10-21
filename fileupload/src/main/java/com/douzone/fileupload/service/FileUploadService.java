package com.douzone.fileupload.service;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH="/upload-images";
	private static String URL_BASE="/images";
	
	public String restore(MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		String url = null;
		try {
			
		
		if(multipartFile.isEmpty()) {
			//업로드 사진이 없을 경우
			return url;
		}
		
		String originFilename = multipartFile.getOriginalFilename();
		String extName = originFilename.substring(originFilename.lastIndexOf('.')+1);
		String saveFilename = generateSavaFilename(extName);
		//파일 사이즈
		long fileSize = multipartFile.getSize();
		
		System.out.println("########"+originFilename);
		System.out.println("########"+fileSize);
		System.out.println("########"+saveFilename);
		
		byte[] data = multipartFile.getBytes();
		OutputStream os = new FileOutputStream(SAVE_PATH+"/"+saveFilename);
		os.write(data);
		os.close();
		
		url = URL_BASE+"/"+saveFilename;
		
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("file upload error : "+e);
		}
		return url;
	}

	private String generateSavaFilename(String extName) {
		// TODO Auto-generated method stub
		String filename ="";
		
		Calendar calendar = Calendar.getInstance();
		
		filename += calendar.get(calendar.YEAR);
		filename += calendar.get(calendar.MONTH);
		filename += calendar.get(calendar.DATE);
		filename += calendar.get(calendar.HOUR);
		filename += calendar.get(calendar.MINUTE);
		filename += calendar.get(calendar.SECOND);
		filename += calendar.get(calendar.MILLISECOND);
		filename += ("."+extName);
		
		
		return filename;
	}
	
}
