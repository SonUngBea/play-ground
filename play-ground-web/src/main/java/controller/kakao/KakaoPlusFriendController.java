package controller.kakao;

import com.google.common.collect.Lists;
import com.playground.domain.application.kakao.dto.KakaoKeyboardDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by woongs on 2017. 12. 23..
 */
@Controller
public class KakaoPlusFriendController {

	@RequestMapping(value = "/keyboard")
	@ResponseBody
	public KakaoKeyboardDto kakaoKeyboard() {
		return KakaoKeyboardDto.builder()
			.type("text")
			.build();
	}
}
