package com.playground.domain.application.calendar;

import com.playground.domain.application.calendar.dto.DiaryDto;
import com.playground.domain.repository.Diary;
import com.playground.domain.repository.DiaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by woongs on 2017. 12. 18..
 */
@Service
@Transactional
public class CalendarService {
	@Autowired
	private DiaryRepository diaryRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public List<DiaryDto> findDiaryByYearAndMonth(Integer year, Integer month) {
		List<Diary> diarys = diaryRepository.findByYearAndMonth(year, month);
		if (CollectionUtils.isEmpty(diarys)) {
			return null;
		}
		return diarys.stream().map(diary -> {
			return modelMapper.map(diary, DiaryDto.class);
		}).collect(Collectors.toList());

	}

	public DiaryDto findDiaryByYearAndMonthAndDay(Integer year, Integer month, Integer day) {
		Diary diary = diaryRepository.findByYearAndMonthAndDay(year, month, day);
		if (diary == null) {
			return null;
		}
		return modelMapper.map(diary, DiaryDto.class);
	}

	public String diarySaveTemplate() {
		return "[일기 쓰기]\n[제목] : \n[내용] : ";
	}

	public Boolean writeDiary(String command) {
		int titleStart = command.indexOf("[제목] :");
		int titleEnd = command.indexOf("[내용] : ");

		String titleContentWithTemplate = command.substring(titleStart, titleEnd);
		String contentWithTemplate = command.substring(titleEnd);
		int seperator = titleContentWithTemplate.indexOf(":") + 1;
		String title = titleContentWithTemplate.substring(seperator);
		String content =  contentWithTemplate.substring(seperator);

		saveTodayDiary(title, content);

		return Boolean.TRUE;
	}

	@Transactional(readOnly = false)
	public void saveTodayDiary(String title, String content) {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		Diary diary = diaryRepository.findByYearAndMonthAndDay(year, month, day);
		if (diary == null) {
			diary = new Diary();
			diary.setYear(year);
			diary.setMonth(month);
			diary.setDay(day);
		}
		diary.setContent(content);
		diary.setTitle(title);

		diaryRepository.save(diary);
	}
}
