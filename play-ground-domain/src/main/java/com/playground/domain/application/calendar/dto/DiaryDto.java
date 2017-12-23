package com.playground.domain.application.calendar.dto;

import lombok.*;

/**
 * Created by woongs on 2017. 12. 18..
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiaryDto {
	private Integer id;

	private String title;

	private String userId;

	private Integer year;

	private Integer month;

	private Integer day;

	private String content;
}
