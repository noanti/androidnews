package com.coco67.hi;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class RssParser {
	private URL url;
	static String[] rssurls= {"http://news.ifeng.com/rss/index.xml","http://news.ifeng.com/mil/rss/index.xml",
						"http://news.ifeng.com/history/rss/index.xml","http://news.ifeng.com/rss/mainland.xml",
						"http://news.ifeng.com/rss/taiwan.xml","http://news.ifeng.com/rss/world.xml",
						"http://news.ifeng.com/rss/society.xml"};
	News[] newslist=new News[30];
	public int count = 0;
	
	public RssParser(int ind) throws IOException{
		url = new URL(rssurls[ind]);
		URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        
//        StringBuffer answer = new StringBuffer();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            answer.append(line);
//        }
//        reader.close();
        DocumentBuilderFactory domfac=DocumentBuilderFactory.newInstance();  
        
        try {  
            DocumentBuilder dombuilder=domfac.newDocumentBuilder();  
            InputStream is=conn.getInputStream();
            Document doc=dombuilder.parse(is);  
            Element root=doc.getDocumentElement();
            NodeList channel=root.getChildNodes();
//            System.out.println("channel len:"+channel.getLength());
            Node root1 = channel.item(1);
//            System.out.println("root1:"+root1.getNodeName());
//            Node root2 = channel.item(1);
//            System.out.println("root2:"+root2.getNodeName());
//            Node root3 = channel.item(2);
//            System.out.println("root3:"+root3.getNodeName());
            NodeList items=root1.getChildNodes();
            if(items!=null){  
                for(int i=1;i<items.getLength()-1;i++){  
                    Node it=items.item(i);  
                    if (!it.getNodeName().equals("item")) continue;
                    if(it.getNodeType()==Node.ELEMENT_NODE){
                    	newslist[count] = new News();
                    	Log.d("info", "item count:"+items.getLength());
                        for(Node node=it.getFirstChild();node!=null;node=node.getNextSibling())
                        {  
                            if(node.getNodeType()==Node.ELEMENT_NODE)
                            {  
                            	if (node.getNodeName().equals("title"))
                            		newslist[count].title = node.getFirstChild().getNodeValue();
                            	if (node.getNodeName().equals("description"))
                            	{                            		
                            		String raw = node.getFirstChild().getNextSibling().getNodeValue();
                            		int index = raw.indexOf("<a href=");
                            		newslist[count].digest=raw.substring(0,index);
                            	}
                            	if (node.getNodeName().equals("link"))
                            		newslist[count].link = node.getFirstChild().getNodeValue();
                            	if (node.getNodeName().equals("pubDate"))
                            	{
                            		String raw = node.getFirstChild().getNodeValue();                            		
                            		newslist[count].time=raw.substring(5, raw.length()-5);
                            	}                         		
                            }                         
                        } 
                        count++;
                        if (count==30) return;
                    }  
                }  
            }
        } catch (ParserConfigurationException e){  
            e.printStackTrace();  
       } catch (FileNotFoundException e){  
             e.printStackTrace();  
        } catch (SAXException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
	}
	public News[] getList(){
		return newslist;
	}
	static public void main(String[] args)
	{
//		try {
//			//RssParser rp = new RssParser(0);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
