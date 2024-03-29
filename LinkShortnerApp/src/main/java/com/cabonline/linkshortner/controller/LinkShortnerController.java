package com.cabonline.linkshortner.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cabonline.linkshortner.service.LinkShortnerService;

@RestController
public class LinkShortnerController {

	@Autowired
	private LinkShortnerService linkShortnerService;

	@RequestMapping("/linkShortner/getShortLink")
	public String getShortLink(@RequestBody String longLink) {
		return linkShortnerService.getShortLink(longLink);
	}

	@RequestMapping("/linkShortner/connectToLink")
	public void connect(@RequestBody String shortLink, HttpServletResponse response) {
		linkShortnerService.connect(shortLink, response);
	}

}
