package com.playground.domain.application.calendar;

import com.playground.domain.application.calendar.dto.DiaryDto;
import com.playground.domain.repository.Diary;
import com.playground.domain.repository.DiaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by woongs on 2017. 12. 18..
 */
@Service
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
}
