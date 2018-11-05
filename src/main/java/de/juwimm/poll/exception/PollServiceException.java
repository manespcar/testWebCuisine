package de.juwimm.poll.exception;

public class PollServiceException extends Exception {

	private static final long serialVersionUID = 7515984829984325457L;
	
	public PollServiceException(String msg, Exception ex) {
		super(msg, ex);
	}

}
