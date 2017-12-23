package controller.calendar.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by woongs on 2017. 12. 18..
 */
@Getter
@Setter
@Builder
public class CalendarEventTitleDto {
	private String title;

	private Boolean allDay;

	private Date start;

	private Date end;
}