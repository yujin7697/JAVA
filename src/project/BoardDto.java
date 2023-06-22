package project;

public class BoardDto {
	String no;
	String name;
	String title;
	String contents;
	String date;
	
	
	public BoardDto(String no, String name, String title, String contents, String date) {
		super();
		this.no = no;
		this.name = name;
		this.title = title;
		this.contents = contents;
		this.date = date;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	

}
