package com.playground.domain.application.kakao.dto;

import lombok.*;

/**
 * Created by woongs on 2017. 12. 24..
 */
@ToString
@EqualsAndHashCode
@SuppressWarnings("PMD.UnusedPrivateField")
@Setter
@Getter
public class KakaoMessageRequestDto {
	private String user_key;

	private String type;

	private String content;
}
