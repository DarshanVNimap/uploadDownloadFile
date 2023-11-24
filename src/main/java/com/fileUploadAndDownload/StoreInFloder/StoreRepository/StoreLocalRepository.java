package com.fileUploadAndDownload.StoreInFloder.StoreRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fileUploadAndDownload.StoreInFloder.model.StoreLocal;

public interface StoreLocalRepository extends JpaRepository<StoreLocal, Short>{
	
	public Optional<StoreLocal> findByFileName(String fileName);

}
