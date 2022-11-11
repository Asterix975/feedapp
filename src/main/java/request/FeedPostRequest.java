package request;

public class FeedPostRequest {

	
	String fromDate;
	String toDate;
	String QueryKeyword;
	String username;
	
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getQueryKeyword() {
		return QueryKeyword;
	}
	public void setQueryKeyword(String queryKeyword) {
		QueryKeyword = queryKeyword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	} 
	

}
