package com.fileUploadAndDownload.StoreInFloder.controller;

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

import com.fileUploadAndDownload.StoreInFloder.StoreLocalService.StoreLocalService;

@RestController
@RequestMapping("/local")
public class StoreLocalController {
	
	@Autowired
	private StoreLocalService service;

	@PostMapping
	public ResponseEntity<?> uploadFile(@RequestParam(name = "image") MultipartFile file) throws IllegalStateException, IOException {
		
		return ResponseEntity.status(HttpStatus.OK)
							 .body(service.uploadFile(file));
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<?> dowloadFile(@PathVariable String name) throws IOException{
		
		return ResponseEntity
							 .status(HttpStatus.OK)
							 .contentType(MediaType.valueOf("image/jpg"))
							 .body(service.dowloadFile(name));
	}
}
