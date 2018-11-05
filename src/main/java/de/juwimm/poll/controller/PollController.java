package de.juwimm.poll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.juwimm.poll.dto.PollDto;
import de.juwimm.poll.exception.PollServiceException;
import de.juwimm.poll.model.Poll;
import de.juwimm.poll.service.PollService;
import de.juwimm.poll.utils.Converter;

@RestController
@RequestMapping("/poll/")
public class PollController {
	
	@Autowired
	private PollService pollService;

	@GetMapping(path = "{id}")
	public ResponseEntity<PollDto> getPollById(@PathVariable Integer id) throws Exception {
		PollDto dto = null;
		Poll poll = pollService.getPollById(id);
		if(poll != null){
			dto = Converter.convertPollToPollDto(poll);
			return new ResponseEntity<PollDto>(dto, HttpStatus.OK);
		}
		else
			return new ResponseEntity<PollDto>(dto, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path = "name/{name}/site/{site}")
	public ResponseEntity<PollDto> getPollBySiteAndName(@PathVariable String name, @PathVariable String site) throws Exception {
		PollDto dto = null;
		Poll poll = pollService.getPollBySiteAndName(site, name);
		if(poll != null){
			dto = Converter.convertPollToPollDto(poll);
			return new ResponseEntity<PollDto>(dto, HttpStatus.OK);
		}
		else
			return new ResponseEntity<PollDto>(dto, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "save")
	public ResponseEntity<PollDto> savePoll(@RequestBody PollDto dto) throws Exception {
		try {
			Poll poll = pollService.savePoll(Converter.convertPollDtoToPoll(dto));
			dto = Converter.convertPollToPollDto(poll);
			return new ResponseEntity<PollDto>(dto, HttpStatus.CREATED);
		} catch (PollServiceException e) {
			return new ResponseEntity<PollDto>(dto, HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping(value = "updateById")
	public ResponseEntity<PollDto> updatePollById(@RequestBody PollDto dto) throws Exception {
		try {
			pollService.updatePollById(Converter.convertPollDtoToPoll(dto));
			return new ResponseEntity<PollDto>(dto, HttpStatus.OK);
		} catch (PollServiceException e) {
			return new ResponseEntity<PollDto>(dto, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "updateByNameAndSite")
	public ResponseEntity<PollDto> updateByNameAndSite(@RequestBody PollDto dto) throws Exception {
		try {
			pollService.updatePollBySiteAndName(Converter.convertPollDtoToPoll(dto));
			return new ResponseEntity<PollDto>(dto, HttpStatus.OK);
		} catch (PollServiceException e) {
			return new ResponseEntity<PollDto>(dto, HttpStatus.NOT_FOUND);
		}
	}
}
