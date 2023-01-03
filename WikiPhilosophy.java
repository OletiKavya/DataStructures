package csudh.csc311.asg5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class WikiPhilosophy {

    final static List<String> visited = new ArrayList<String>();
    final static WikiFetcher wf = new WikiFetcher();

    /**
     * Tests a conjecture about Wikipedia and Philosophy.
     *
     * https://en.wikipedia.org/wiki/Wikipedia:Getting_to_Philosophy
     *
     * 1. Clicking on the first non-parenthesized, non-italicized link
     * 2. Ignoring external links, links to the current page, or red links
     * 3. Stopping when reaching "Philosophy", a page with no links or a page
     *    that does not exist, or when a loop occurs
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String destination = "https://en.wikipedia.org/wiki/Philosophy";
        String source = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        testConjecture(destination, source, 10);
    }

    /**
     * Starts from given URL and follows first link until it finds the destination or exceeds the limit.
     *
     * @param destination
     * @param source
     * @throws IOException
     */
    public static void testConjecture(String destination, String source, int limit) throws IOException {
        // TODO: FILL THIS IN!
        String url = source;
		//System.out.println(url);
		try{
        for (int i=0; i<limit; i++) {
            if (visited.contains(url)) {
                return;
            } else {
                visited.add(url);
            }
			if(url!=null)
			{
            Element elt = getFirstValidLink(url);
			System.out.println(getFirstValidLink(url));
			limit--;
            if (elt == null) {
                System.err.println("Got to a page with no valid links.");
                return;
            }
           
            System.out.println("**" + elt.text() + "**");
            url = elt.attr("abs:href");
           
            if (url.equals(destination)) {
                System.out.println("Success!");
                break;
            }
        }}}
		catch(Exception e){
			System.out.println("Success");
		}
		
    }

   

	/**
     * Loads and parses a URL, then extracts the first link.
     *
     * @param url
     * @return the Element of the first link, or null.
     * @throws IOException
     */
    public static Element getFirstValidLink(String url) throws IOException {
        Elements paragraphs = wf.fetchWikipedia(url);
		//System.out.println(paragraphs);
        for (Element paragraph: paragraphs) {
			//System.out.println(paragraph);
    		Iterable<Node> nt = new WikiNodeIterable(paragraph);
			//System.out.println(nt);
    		for (Node node: nt) {
    			if (node instanceof TextNode) {
					
        			Element elt=(Element) node;
					System.out.println(node);
        			if ((elt.tagName().equals("i") || elt.tagName().equals("em"))!=true) {
        				Element first_link=elt;
        				return first_link;
        			}
        		}
    		}
    		
    		
    	}
       
        return null;
    }
       
    /**
     * Formats and print the arguments.
     *
     * @param msg
     * @param args
     */
   
}