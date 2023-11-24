package com.fileUploadAndDownload.storeInDatabase.storedbservice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fileUploadAndDownload.storeInDatabase.imageRepo.FileDataRepository;
import com.fileUploadAndDownload.storeInDatabase.model.FileData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StoreInLocalService {
	
	
	
	@Autowired
	private FileDataRepository repository;
	
	private final String FOLDER_PATH = "C:\\Users\\Nimap\\Desktop\\LocalStorage\\";
	
	public String uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		
		log.info("Start uploading......");
		
		String filePath = FOLDER_PATH + file.getOriginalFilename();
		
		FileData getFile = repository.save(
				FileData.build((short) 0 ,
								file.getOriginalFilename(),
								file.getContentType(),
								filePath)
				);
		
		file.transferTo(new File(filePath));
		
		if(getFile != null) { 
				log.info("File uploaded at "+filePath);
				return "File uploaded!!";
				}
		
		log.error("File couldn't uploaded");
		return "Somthing went wrong!!";
	}
	
	public byte[] downloadFile(String name) throws IOException {
		
		log.info("Start downloading...");
		
		FileData getFile = repository.findByFileName(name).orElseThrow();
		String getPath = getFile.getFilePath();
		log.info("File downloaded!");
		return Files.readAllBytes(new File(getPath).toPath());
		
		
	}

}
