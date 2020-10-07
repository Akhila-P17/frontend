package org.tool.collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="collection")
public class CollectionEntity {
	
	@Id	
	private String subject_code;
	
	private String  collection_name;
	
	private String  collectionCode;
	
	
	
	
	
	
	public CollectionEntity(String subject_code, String collection_name, String collectionCode) {
		super();
		this.subject_code = subject_code;
		this.collection_name = collection_name;
		this.collectionCode = collectionCode;
	}





	public CollectionEntity() {
		
	}





	public String getSubject_code() {
		return subject_code;
	}





	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}





	public String getCollection_name() {
		return collection_name;
	}





	public void setCollection_name(String collection_name) {
		this.collection_name = collection_name;
	}





	public String getCollectionCode() {
		return collectionCode;
	}





	public void setCollectionCode(String collectionCode) {
		this.collectionCode = collectionCode;
	}





	@Override
	public String toString() {
		return "CollectionEntity [subject_code=" + subject_code + ", collection_name=" + collection_name
				+ ", collectionCode=" + collectionCode + "]";
	}

}