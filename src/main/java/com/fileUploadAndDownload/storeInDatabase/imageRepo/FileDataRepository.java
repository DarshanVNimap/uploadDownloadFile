package com.fileUploadAndDownload.storeInDatabase.imageRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fileUploadAndDownload.storeInDatabase.model.FileData;

public interface FileDataRepository extends JpaRepository<FileData, Short> {
	
	public Optional<FileData> findByFileName(String name);

}
