package com.fileUploadAndDownload.StoreInFloder.StoreLocalService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fileUploadAndDownload.StoreInFloder.StoreRepository.StoreLocalRepository;
import com.fileUploadAndDownload.StoreInFloder.model.StoreLocal;

@Service
public class StoreLocalService {

	@Autowired
	private StoreLocalRepository repository;
	private final String FOLDER_PATH = "/Users/Nimap/Desktop/LocalStorage/";
	
	
	public String uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		String file_path = FOLDER_PATH + file.getOriginalFilename();
		
		StoreLocal storedFile = repository.save(
				StoreLocal.build((short)0 ,
						file.getOriginalFilename(),
						file.getContentType(),
						file_path)
				);
		
		file.transferTo(new File(FOLDER_PATH));
		
		if(storedFile != null) return "File uploaded successfully : "+ file.getOriginalFilename(); 
		
		return "something went wrong!!";
	}
	
	
	public byte[] dowloadFile(String fileName) throws IOException {
		
		StoreLocal getFileData = repository.findByFileName(fileName).orElseThrow();
		String getPath = getFileData.getFilePath();
	
		return Files.readAllBytes(new File(getPath).toPath());
	}
	
}
