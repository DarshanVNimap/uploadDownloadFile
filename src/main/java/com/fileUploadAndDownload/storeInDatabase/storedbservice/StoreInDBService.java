package com.fileUploadAndDownload.storeInDatabase.storedbservice;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fileUploadAndDownload.storeInDatabase.imageRepo.StoreDbRepository;
import com.fileUploadAndDownload.storeInDatabase.model.ImageData;
import com.fileUploadAndDownload.utils.StorageUtils;

@Service
public class StoreInDBService {
	
	@Autowired
	private StoreDbRepository repository;
	
	public String uploadFile(MultipartFile file) throws IOException {
		
		ImageData image = repository.save(
					ImageData.build((short)0,
								file.getOriginalFilename(),
								file.getContentType(),
								StorageUtils.compressImage(file.getBytes())
							)
				);
		
		if(image != null) return "file uploaded successfully: "+file.getName();
		return "Somthing went wrong";
	}
	
	public byte[] downloadFile(String fileName) {
		
	 ImageData image = repository.findByFileName(fileName).orElseThrow();
		return StorageUtils.decompressImage(image.getFileData()); 
	}
	
	
	
	
	
	

}
