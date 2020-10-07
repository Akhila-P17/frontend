package org.tool.collection;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {

	
 List<QuestionEntity> findByCollectionCode(String collectionCode);
 
}