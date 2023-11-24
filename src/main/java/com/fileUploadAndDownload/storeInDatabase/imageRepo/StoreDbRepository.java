package com.fileUploadAndDownload.storeInDatabase.imageRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fileUploadAndDownload.storeInDatabase.model.ImageData;

public interface StoreDbRepository extends JpaRepository<ImageData, Short>{

	Optional<ImageData> findByFileName(String fileName);
}
