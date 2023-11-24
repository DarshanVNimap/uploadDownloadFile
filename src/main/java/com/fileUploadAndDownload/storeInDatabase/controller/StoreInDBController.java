package com.fileUploadAndDownload.storeInDatabase.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fileUploadAndDownload.storeInDatabase.storedbservice.StoreInDBService;

@RestController
@RequestMapping("/blob")
public class StoreInDBController {
	
	@Autowired
	private StoreInDBService service;

	@GetMapping("/{name}")
	public ResponseEntity<?> downloadFile(@PathVariable String name){
		
		byte[] image = service.downloadFile(name);
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/jpeg"))
				.body(image);
	}
	
	@PostMapping
	public ResponseEntity<?> uploadFile(@RequestParam(name = "image") MultipartFile file) throws IOException{
		
		String status = service.uploadFile(file);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(status);
	}
}
