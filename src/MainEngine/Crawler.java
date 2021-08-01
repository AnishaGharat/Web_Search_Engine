// Implement the Web Crawler to get content from the HTML URLs
package MainEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	private static final Logger logger = Logger.getLogger(Crawler.class.getName());

	private static HashMap<String, Integer> pagesCrawledList = new HashMap<String, Integer>();
	private static List<Document> webPageList = new ArrayList<Document>();

	/**
	 * Getter method for Web Page List
	 */
	public List<Document> getWebPagesList() {
		return webPageList;
	}

	/**
	 * Setter method for Web Page List
	 * 
	 * @param List<Document> webPageList: List of type Document
	 */
	public void setWebPageList(List<Document> webPageList) {
		this.webPageList = webPageList;
	}

	private static int maxDepth = 2;

	/**
	 * The method initializes crawling
	 * 
	 * @param String url: URL to be crawled
	 */
	public static void initiateCrawling(String url) {

		logger.log(Level.INFO, "Initiated Crawling");
		System.out.println(
				"*****************************************************************************************************************");

		startCrawler(url, 0);
		logger.log(Level.INFO, "Finished Crawling");
		System.out.println(
				"*****************************************************************************************************************");
	}

	/**
	 * The method checks starts the web crawling
	 * 
	 * @param String url: URL to be crawled
	 * @param int    depth:
	 */
	public static void startCrawler(String url, int depth) {
		if (depth <= maxDepth) {
			try {
				Document document = Jsoup.connect(url).get();
				Parser.saveDoc(document);
				webPageList.add(document);
				depth++;
				if (depth < maxDepth) {
					// Parse the HTML to extract links to other URLs
					Elements links = document.select("a[href]");
					for (Element page : links) {
						if (shouldCrawlUrl(page.attr("abs:href"))) {
							System.out.println(page.attr("abs:href"));
							startCrawler(page.attr("abs:href"), depth);
							pagesCrawledList.put(page.attr("abs:href"), depth);
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Error fetching url - " + url);
			}
		}
	}

	/**
	 * The method checks if the web URL can be crawled
	 * 
	 * @param String nextURL: URL to be crawled
	 * @return Boolean value: true | false
	 */
	private static boolean shouldCrawlUrl(String nextUrl) {
		if (pagesCrawledList.containsKey(nextUrl)) {
			return false;
		}
		if (nextUrl.startsWith("javascript:")) {
			return false;
		}
		if (nextUrl.contains("mailto:")) {
			return false;
		}
		if (nextUrl.contains("#") || nextUrl.contains("?")) {
			return false;
		}
		if (nextUrl.endsWith(".swf")) {
			return false;
		}
		if (nextUrl.endsWith(".txt")) {
			return false;
		}
		if (nextUrl.endsWith(".pdf")) {
			return false;
		}
		if (nextUrl.endsWith(".png")) {
			return false;
		}
		if (nextUrl.endsWith(".gif")) {
			return false;
		}
		if (nextUrl.endsWith(".jpg")) {
			return false;
		}
		if (nextUrl.endsWith(".jpeg")) {
			return false;
		}
		return true;
	}

}
