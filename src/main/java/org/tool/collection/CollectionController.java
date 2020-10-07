package org.tool.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tool.reponse.ResponseMessage;

@RestController
public class CollectionController {

	@Autowired
	private CollectionRepository collectionRepository;

	@Autowired
	private ResponseMessage responseMessage;

	@Autowired
	private QuestionRepository questionRepository;

	@PostMapping("/create/new/collection")
	public ResponseMessage method(@RequestBody CollectionEntity collectionEntity) {

		collectionEntity
				.setCollectionCode(java.time.LocalTime.now().toString().replaceAll(":", "").replaceAll("\\.", ""));
		collectionRepository.save(collectionEntity);
		responseMessage.setStatus("success");
		return responseMessage;

	}

	@PostMapping("/add/questions")
	public ResponseMessage method2(@RequestBody List<QuestionEntity> questionEntity) {

		for (QuestionEntity questionEntity2 : questionEntity) {
			questionEntity2
					.setQuestion_code(java.time.LocalTime.now().toString().replaceAll(":", "").replaceAll("\\.", ""));
			questionRepository.saveAll(questionEntity);

		}

		responseMessage.setStatus("success");

		return responseMessage;
	}

	@GetMapping("/get/questions/{collectionCode}")
	public List<HashMap<String,Object>> generateQuestion(@PathVariable("collectionCode") String collectionCode) {
		
		List<QuestionEntity> questions = new ArrayList<>();
		questions.addAll(questionRepository.findByCollectionCode(collectionCode));
		
		
		List<HashMap<String,Object>> questionsToSend = new ArrayList<>();
		
		
		for(int i=0; i<questions.size(); i++ ){ 
			HashMap<String, Object> questionList = new HashMap<>(); 
			questionList.put("collectionCode", questions.get(i).getCollectionCode());
			questionList.put("questionCode", questions.get(i).getQuestion_code());
			questionList.put("question", questions.get(i).getQuestion());
			questionList.put("choices", questions.get(i).getAnswer().replaceAll("t_","").replaceAll("f_",""));
			
			
			
                 questionsToSend.add(questionList);
               Collections.shuffle(questionsToSend);  
			
			}
		
		return questionsToSend; 

}

}
