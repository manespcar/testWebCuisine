package de.juwimm.poll.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.juwimm.poll.exception.PollServiceException;
import de.juwimm.poll.model.Poll;
import de.juwimm.poll.respositories.PollRepository;
import de.juwimm.poll.service.PollService;

@Service
public class PollServiceImpl implements PollService {
	
	@Autowired
	private PollRepository pollRepository;

	@Override
	public Poll getPollById(Integer id) throws PollServiceException{
		Optional<Poll> poll = pollRepository.findById(id);
		try {
			return poll.get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public Poll getPollBySiteAndName(String site, String name) {
		return pollRepository.findByNameAndSite(name.toUpperCase(), site.toUpperCase());
	}

	@Override
	public Poll savePoll(Poll poll) throws PollServiceException {
		try {
			return pollRepository.save(poll);
		} catch (Exception e) {
			throw new PollServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void updatePollById(Poll poll) throws PollServiceException {
		Poll p = this.getPollById(poll.getId());
		if(p == null)
			throw new PollServiceException("Not found", new Exception());
		
		try {
			pollRepository.updateById(poll.getId(), poll.getXmldata());
		} catch (Exception e) {
			throw new PollServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void updatePollBySiteAndName(Poll poll) throws PollServiceException {
		Poll p = this.getPollBySiteAndName(poll.getSite().toUpperCase(), poll.getName().toUpperCase());
		if(p == null)
			throw new PollServiceException("Not found", new Exception());
		
		try {
			pollRepository.updateBySiteAndName(poll.getName().toUpperCase(), poll.getSite().toUpperCase(), poll.getXmldata());
		} catch (Exception e) {
			throw new PollServiceException(e.getMessage(), e);
		}
	}

}
