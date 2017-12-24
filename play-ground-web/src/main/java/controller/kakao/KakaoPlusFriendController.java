package controller.kakao;

import com.playground.domain.application.kakao.KakaoInterpreter;
import com.playground.domain.application.kakao.dto.KakaoKeyboardDto;
import com.playground.domain.application.kakao.dto.KakaoMessageRequestDto;
import com.playground.domain.application.kakao.dto.KakaoMessageResponseDto;
import com.playground.domain.application.kakao.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by woongs on 2017. 12. 23..
 */
@Slf4j
@Controller
public class KakaoPlusFriendController {
	@Autowired
	private KakaoInterpreter kakaoInterpreter;

	@RequestMapping(value = "/keyboard")
	@ResponseBody
	public KakaoKeyboardDto kakaoKeyboard() {
		return KakaoKeyboardDto.builder()
			.type("text")
			.build();
	}

	@RequestMapping(value = "/message", method = RequestMethod.POST)
	@ResponseBody
	public KakaoMessageResponseDto kakaoMessage(@RequestBody KakaoMessageRequestDto requestDto) {
		log.info("[Kakao] Get message from kakao {}", requestDto);
		Message message = new Message();
		message.setText(kakaoInterpreter.parsingAndExecute(requestDto.getContent()));
		return KakaoMessageResponseDto.builder().message(message).build();
	}
}
