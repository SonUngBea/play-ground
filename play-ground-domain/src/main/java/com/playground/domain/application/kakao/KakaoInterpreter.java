package com.playground.domain.application.kakao;

import com.playground.domain.application.calendar.CalendarService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by woongs on 2017. 12. 24..
 */
@Service
public class KakaoInterpreter {
	@Autowired
	private CalendarService calendarService;

	//TODO:woongs 명령어 Enum 으로
	//TODO:woongs Parsing 과 Execute 구조화
	public String parsingAndExecute(String command) {
		if (StringUtils.contains(command,"[템플릿]")) {
			return calendarService.diarySaveTemplate();
		} else if (StringUtils.contains(command,"[일기 쓰기]")) {
			calendarService.writeDiary(command);
			return "[일기 쓰기] 성공하였습니다.";
		} else if (StringUtils.contains(command,"[?]")) {
			return "[템플릿], [일기 쓰기], [?]";
		}
		return "일치하는 명령어를 찾지 못하였습니다.\n[?]를 입력해 보세요";
	}
}
