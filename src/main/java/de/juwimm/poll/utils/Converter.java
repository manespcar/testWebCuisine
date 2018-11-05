package de.juwimm.poll.utils;

import de.juwimm.poll.dto.PollDto;
import de.juwimm.poll.model.Poll;

public class Converter {
	
	public static PollDto convertPollToPollDto(Poll bean) {
		PollDto dto = new PollDto();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		dto.setSite(bean.getSite());
		dto.setXmldata(bean.getXmldata());
		return dto;
	}
	
	public static Poll convertPollDtoToPoll(PollDto dto) {
		Poll bean = new Poll();
		bean.setId(dto.getId());
		bean.setName(dto.getName());
		bean.setSite(dto.getSite());
		bean.setXmldata(dto.getXmldata());
		return bean;
	}

}
