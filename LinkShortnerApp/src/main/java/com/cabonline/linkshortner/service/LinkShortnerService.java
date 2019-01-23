package com.cabonline.linkshortner.service;

import javax.servlet.http.HttpServletResponse;

public interface LinkShortnerService {
	
	public String getShortLink(String longLink);
	
	public void connect(String link, HttpServletResponse response);

}
