package com.mit.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mit.algorithm.Latitude;
import com.mit.algorithm.XY;
import com.mit.dto.User;
import com.mit.returnDto.LatitudeDto;
import com.mit.service.MemberService;
import com.mit.service.UserService;
import com.sun.mail.handlers.message_rfc822;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/teammanagement")
public class TeamManagementController {
	private static final Logger logger = LoggerFactory.getLogger(TeamManagementController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	UserService userService;

	@ApiOperation(value = "최적의 장소 구해주는 api")
	@GetMapping
	public ResponseEntity<LatitudeDto> recomendSite(@RequestParam("no") String no,
			@RequestParam("leaderemail") String leaderemail) {
		LatitudeDto latitudeDto = new LatitudeDto();

		List<XY> lotates = new ArrayList<XY>();

		Latitude latitude = new Latitude();

		/*
		 * no email을 이용하여 team에 등록된 모든 멤버의 email가져오고 이 email을 이용해서 user의 현재 주소를 가져온다.
		 * 이주소를 List<String> 에 넣는다. 주소<String> 을 이용해서 lotates.add(XY) 값을 넣는다. N개의 x,y 의
		 * 좌표를 가지고 중간값의 x,y를 찾는다. 중간값의 x,y 반경 K Km 안에 스터디 카페 || 카페 (Review 가 높은 순으로
		 * 구한다.)
		 */

		List<User> users = userService.selectAddressMember(no, leaderemail);

		for (User user : users) {
			XY xy = latitude.GetLatitude(user.getAddress());
			xy.setName(user.getNickname());
			if (xy != null) {
				latitudeDto.getMembers().add(xy);
			}
		}

		return new ResponseEntity<LatitudeDto>(latitudeDto, HttpStatus.FAILED_DEPENDENCY);
	}
}
