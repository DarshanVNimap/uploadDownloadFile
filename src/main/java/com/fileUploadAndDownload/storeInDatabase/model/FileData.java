package com.fileUploadAndDownload.storeInDatabase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Table(name = "storeInLocal")
public class FileData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private short id;
	private String fileName;
	private String type;
	private String filePath;

}
