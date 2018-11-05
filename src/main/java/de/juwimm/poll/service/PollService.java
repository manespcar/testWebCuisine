package de.juwimm.poll.service;

import de.juwimm.poll.exception.PollServiceException;
import de.juwimm.poll.model.Poll;

public interface PollService {
	
	Poll getPollById(Integer id) throws PollServiceException;
	
	Poll getPollBySiteAndName(String site, String name);
	
	Poll savePoll(Poll poll) throws PollServiceException;

	void updatePollById(Poll poll) throws PollServiceException;
	
	void updatePollBySiteAndName(Poll poll) throws PollServiceException;

}
