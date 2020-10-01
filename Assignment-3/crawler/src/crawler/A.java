package crawler;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import org.apache.commons.math3.util.Pair;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.jsoup.*;
import java.util.*;

public class A {

	public static Set<String> Urls=new HashSet<String>();
	public static Queue<Pair<String,Integer>> UrlstoTraverse=new LinkedList<Pair<String,Integer>>();
	public static String site="pec.ac.in";
	public static int s1rowNumber=2;
	public static int s2rowNumber=2;
	public static Workbook wb = new HSSFWorkbook();
	public static Sheet sheet1 = wb.createSheet("Text tags Sheet");
	public static Sheet sheet2 = wb.createSheet("Anchor tags sheet");
	public static int maxDepth=4;
	
	public static void main(String[] args) {
		try 
		{
			A obj=new A();
			Row row1 =sheet1.createRow(0);
			row1.createCell(0).setCellValue("Tag");
			row1.createCell(1).setCellValue("Text");
			Row row2 =sheet2.createRow(0);
			row2.createCell(0).setCellValue("Text");
			row2.createCell(1).setCellValue("Link");
			Urls.add("https://www.pec.ac.in/");
			Urls.add("https://pec.ac.in/");
			
			obj.getUrls("https://pec.ac.in/",1);
			while(!UrlstoTraverse.isEmpty())
			{
				Pair<String,Integer> TrUrl=UrlstoTraverse.poll();

				obj.getUrls(TrUrl.getKey(), TrUrl.getValue());
			}
			try (OutputStream fileOut = new FileOutputStream("A.xls")) {
			    wb.write(fileOut);
			}
			wb.close();
			System.out.println("Done !!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void getUrls(String url,int depth)
	{
		if(depth>maxDepth)
			return;
		try {
			System.out.println("Crawling "+url);
			Document document=Jsoup.connect(url).get();
			for(Element data : document.select("*"))
			{
				String tag=data.tagName();
				String text=data.ownText();
				if(text.isEmpty() || tag=="a")
					continue;
				Row row =sheet1.createRow(s1rowNumber);
				row.createCell(0).setCellValue(tag);
				row.createCell(1).setCellValue(text);
				s1rowNumber++;
			}
			Elements links=document.select("a");
			if(links.isEmpty())
				return;
			for(Element link: links)
			{
				String absUrl=link.attr("abs:href");
				if(absUrl.isEmpty() || absUrl.contains(".pdf") || absUrl.contains(".PDF") || absUrl.endsWith(".doc") || absUrl.endsWith(".DOC") || absUrl.contains(".docx") || absUrl.endsWith(".xls") || absUrl.contains(".xlsx") || absUrl.endsWith(".jpg") || absUrl.endsWith(".JPG") || absUrl.endsWith(".jpeg") || absUrl.endsWith("#") || absUrl.endsWith("#main-content") || absUrl.endsWith("#0") || absUrl.startsWith("mailto") || absUrl.contains("mail"))
					continue;
				String text=link.text();
				boolean add=Urls.add(absUrl);
				if(add==true)
				{
					Row row =sheet2.createRow(s2rowNumber);
					row.createCell(0).setCellValue(text);
					row.createCell(1).setCellValue(absUrl);
					s2rowNumber++;
						
				}
				else
					continue;
				if(absUrl.contains(site) && depth<maxDepth)
				{
					UrlstoTraverse.add(new Pair<> (absUrl,depth+1));
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}