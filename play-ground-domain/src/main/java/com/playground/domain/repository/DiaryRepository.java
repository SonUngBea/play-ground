package com.playground.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by woongs on 2017. 12. 18..
 */
@Repository
public interface DiaryRepository extends CrudRepository<Diary, Integer> {
	List<Diary> findByYearAndMonth(Integer year, Integer month);

	Diary findByYearAndMonthAndDay(Integer year, Integer month, Integer day);
}
