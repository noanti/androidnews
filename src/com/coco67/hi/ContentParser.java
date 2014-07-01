package com.coco67.hi;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ContentParser {
	public URL url;
	public ContentParser(String source) throws IOException
	{
		url = new URL(source);
		URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
	}

}
