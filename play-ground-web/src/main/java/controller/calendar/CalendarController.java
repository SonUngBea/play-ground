package controller.calendar;

import com.playground.domain.application.calendar.CalendarService;
import com.playground.domain.application.calendar.dto.DiaryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by woongs on 2017. 12. 18..
 */
@Controller
@RequestMapping(value = "/calendar")
public class CalendarController {
	@Autowired
	private CalendarService calendarService;

	@RequestMapping(value = "/diary/list", produces="application/json;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public List<DiaryDto> findDaiaryByYearAndMonth(@RequestParam(value = "year") Integer year, @RequestParam(value = "month") Integer month) {
		List<DiaryDto> result = calendarService.findDiaryByYearAndMonth(year, month);
		return result;
	}

	@RequestMapping(value = "/diary", produces="application/json;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public DiaryDto findDiaryContent(
		@RequestParam(value = "year") Integer year, @RequestParam(value = "month") Integer month, @RequestParam(value = "day") Integer day) {
		DiaryDto result = calendarService.findDiaryByYearAndMonthAndDay(year, month, day);
		return result;
	}

}
