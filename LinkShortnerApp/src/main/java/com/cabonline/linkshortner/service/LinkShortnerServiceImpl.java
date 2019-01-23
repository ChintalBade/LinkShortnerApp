package com.cabonline.linkshortner.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LinkShortnerServiceImpl implements LinkShortnerService {

	private static final Logger logger = LoggerFactory.getLogger(LinkShortnerServiceImpl.class);
	private Map<String, String> linkStore = new HashMap<>();

	@Override
	public String getShortLink(String longLink) {

		String shortLink = "";
		try {
			URL netUrl = new URL(longLink);
			String host = netUrl.getHost();
			String path = netUrl.getPath();
			shortLink = netUrl.getProtocol() + "://" + host + "/" + path.hashCode();
		} catch (MalformedURLException ex) {
			logger.error("URL is malformed", ex);
		}
		linkStore.put(shortLink, longLink);
		return shortLink;
	}

	@Override
	public void connect(String shortLink, HttpServletResponse response) {

		String longLink = linkStore.get(shortLink);
		try {
			response.sendRedirect(longLink);
		} catch (IOException e) {
			logger.error("error occured during connection", e);
		}
	}

}
