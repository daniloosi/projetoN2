package com.javaproject.projeton2;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TimeController {

	@Autowired
	private TimeRepo timeRepo;

	@GetMapping("/teams")
	Iterable<Time> getTimes() {
		return timeRepo.findAll();
	}

	@GetMapping("/teams/{id}")
	Optional<Time> getTime(@PathVariable long id) {
		return timeRepo.findById(id);
	}

	@PostMapping("/create/teams")
	Time createTime(@RequestBody Time t) {
		Time createdTime = timeRepo.save(t);
		return createdTime;
	}

	@PutMapping("/update/teams/{timeId}")
	Optional<Time> updateTime(@RequestBody Time timeRequest, @PathVariable long timeId) {
		Optional<Time> opt = timeRepo.findById(timeId);
		if (opt.isPresent()) {
			if (timeRequest.getId() == timeId) {
				timeRepo.save(timeRequest);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Erro ao alterar dados do time com id " + timeId);
	}

	@DeleteMapping("/delete/teams/{id}")
	void deleteTime(@PathVariable long id) {
		timeRepo.deleteById(id);
	}

}