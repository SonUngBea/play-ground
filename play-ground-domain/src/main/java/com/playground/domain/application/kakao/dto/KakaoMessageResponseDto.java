package com.playground.domain.application.kakao.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by coupang on 2017. 12. 24..
 */
@Getter
@Setter
@Builder
public class KakaoMessageResponseDto {
	private Message message;
}
