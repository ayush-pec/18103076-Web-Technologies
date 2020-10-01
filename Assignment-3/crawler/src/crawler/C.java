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

public class C {

	public static Set<String> Urls=new HashSet<String>();
	public static Queue<Pair<String,Integer>> UrlstoTraverse=new LinkedList<Pair<String,Integer>>();
	public static String site="pec.ac.in";
	public static int s1rowNumber=2;
	public static Workbook wb = new HSSFWorkbook();
	public static Sheet sheet1 = wb.createSheet("Faculty Details");
	public static int maxDepth=4;
	public static String[] keywords= {"/departments","/centres","/faculty","/aero","/cse","/applied-sciences","/civil","/ee","/ece","/me","/metta","/pie","/cmh","/cyber-security-research-centre"};
	
	public static void main(String[] args) {
		try 
		{
			C obj=new C();
			Row row1 =sheet1.createRow(0);
			row1.createCell(0).setCellValue("Name");
			row1.createCell(1).setCellValue("Designation");
			row1.createCell(2).setCellValue("Department");
			row1.createCell(3).setCellValue("Qualification");
			row1.createCell(4).setCellValue("Research Interests");
			row1.createCell(5).setCellValue("Url");
			Urls.add("https://www.pec.ac.in/");
			Urls.add("https://pec.ac.in/");
			obj.getUrls("https://pec.ac.in/",1);
			while(!UrlstoTraverse.isEmpty())
			{
				Pair<String,Integer> TrUrl=UrlstoTraverse.poll();
				if(TrUrl.getKey().contains("/faculty/") || TrUrl.getKey().endsWith("/faculty"))
				{
					obj.getFacultyInfo(TrUrl.getKey());
				}
				else
					obj.getUrls(TrUrl.getKey(), TrUrl.getValue());
			}
			try (OutputStream fileOut = new FileOutputStream("C.xls")) {
			    wb.write(fileOut);
			}
			wb.close();
			System.out.println("Finished");
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
			Elements links=document.select("a");
			if(links.isEmpty())
				return;
			for(Element link: links)
			{
				String absUrl=link.attr("abs:href");
				if(absUrl.isEmpty() || absUrl.contains(".pdf") || absUrl.contains(".PDF") || absUrl.endsWith(".doc") || absUrl.endsWith(".DOC") || absUrl.contains(".docx") || absUrl.endsWith(".xls") || absUrl.contains(".xlsx") || absUrl.endsWith(".jpg") || absUrl.endsWith(".JPG") || absUrl.endsWith(".jpeg") || absUrl.endsWith("#") || absUrl.endsWith("#main-content") || absUrl.endsWith("#0") || absUrl.startsWith("mailto") || absUrl.contains("mail"))
					continue;
				boolean keywordPresent=false;
				for(String keyword:keywords)
				{
					if(absUrl.contains(keyword))
					{
						keywordPresent=true;
						break;
					}
				}
				if(keywordPresent==false)
					continue;
				boolean add=Urls.add(absUrl);
				if(add==true && absUrl.contains(site) && depth<maxDepth)
				{
					UrlstoTraverse.add(new Pair<> (absUrl,depth+1));
					System.out.println("Added "+absUrl);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void getFacultyInfo(String url)
	{
		try {
			System.out.println("Extracting faculty info: "+url);
			Document document=Jsoup.connect(url).get();
			Elements divs=document.select("div.col-md-10");
			for(Element facultyInfo: divs)
			{
				String absUrl=facultyInfo.select("strong a").attr("abs:href");
				String name=facultyInfo.select("strong a").text();
				Row row =sheet1.createRow(s1rowNumber);
				if(!name.isEmpty())
					row.createCell(0).setCellValue(name);
				Elements otherInfo=facultyInfo.select("strong:not(:has(a))");
				int colNumber=1;
				if(name.isEmpty())
					colNumber=0;
				for(Element info: otherInfo)
				{
					if(!(info.ownText().contains("Research Interests:") || info.ownText().contains("Address") || info.ownText().contains("Phone") || info.ownText().contains("Email")))
					{
						row.createCell(colNumber).setCellValue(info.ownText());
						colNumber++;
					}
				}
				row.createCell(colNumber).setCellValue(facultyInfo.ownText());
				colNumber++;
				row.createCell(colNumber).setCellValue(absUrl);
				s1rowNumber++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
