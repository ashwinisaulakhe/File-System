package com.filesystem.springapp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.ManagedBean;

import org.springframework.web.context.annotation.SessionScope;

@ManagedBean
@SessionScope
public class MyController {

  private void doStuff() throws IOException {
  
    String externalServiceUrl = null;
	URL url = new URL(externalServiceUrl);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setDoOutput(true);
    conn.setDoInput(true);

    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
    char[] postData = null;
	wr.write(postData);
    wr.flush();

    InputStream is = conn.getInputStream(); // Warning logged after this line

  }

}