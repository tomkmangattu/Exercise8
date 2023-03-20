package hack;

import java.util.ArrayList;
import java.util.Iterator;


public class BrowserHistory {
	
	private ArrayList<String> historyUrls;
	static final String[] ALLOWABLEDOMAINS = {".com", ".in", ".org"};
	
	public BrowserHistory() {
		historyUrls = new ArrayList<>();
	}
	
	void visit(String url) throws InvalidURLException {
		boolean endsWithAllowableDomains = false;
		for(String domains : ALLOWABLEDOMAINS) {
			if(url.endsWith(domains)) {
				endsWithAllowableDomains = true;
				break;
			}
		}
		
		if(!endsWithAllowableDomains) {
			throw new InvalidURLException("Invalid url extension");
		}
		
		historyUrls.add(url);
	}
	
	void delete(int index) {
		index --;
		if(index < 0 || index >= historyUrls.size()) {
			throw new IndexOutOfBoundsException("Please enter an index between 1 and " + historyUrls.size());
		}
		historyUrls.remove(index);
	}
	
	void displayWithIndex() {
		Iterator<String> iterator = historyUrls.iterator();
		int index = 1;
		
		while(iterator.hasNext()) {
			System.out.println(index++ + " " +  iterator.next());
		}
	}
	
	ArrayList<String> getHistoryUrl() {
		return historyUrls;
	}
	
	void setHistoryUrl(ArrayList<String> historyUrls) {
		this.historyUrls = historyUrls; 
	}
	
}
