package com.fileUploadAndDownload.storeInDatabase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Table(name = "storeInDB")
public class ImageData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private short id;
	private String fileName;
	private String type;
	
	@Lob
	@Column(length = 2000)
	private byte[] fileData;

}
