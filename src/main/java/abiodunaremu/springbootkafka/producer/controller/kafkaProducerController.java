package abiodunaremu.springbootkafka.producer.controller;

import abiodunaremu.springbootkafka.producer.service.KafkaSender;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafkaproducer")
public class kafkaProducerController {

	@Autowired
	private KafkaSender sender;

	@PostMapping
	public ResponseEntity<String> sendData(@RequestBody Student student) {
		System.out.println("Student nameeeeeeeeeee:" + student.getFirstName());
		sender.sendData(student);
		return new ResponseEntity<>("Data sent by kafka", HttpStatus.OK);
	}

}
