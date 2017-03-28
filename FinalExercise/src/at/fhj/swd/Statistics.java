package at.fhj.swd;

public class Statistics {

	private String text;
	private int count;
	private float percentage;
	
	public Statistics (String text, int count, int total) {
		this.text = text;
		this.count = count;
		
		float per = (float) count / (float) total * 100;
		float percen = Math.round(per * 1000);
		this.percentage = percen / 1000;
	}
	
	public Statistics (Character text, int count, int total) {
		this.text = "" + text;
		this.count = count;
		
		float per = (float) count / (float) total * 100;
		float percen = Math.round(per * 1000);
		this.percentage = percen / 1000;
	}
	
//	public void setText(String text) {
//		this.text = text;
//	}
//	public void setCount(int count) {
//		this.count = count;
//	}
//	public void setPercentage(float percentage) {
//		this.percentage = percentage;
//	}
	public String getText() {
		return text;
	}
	public int getCount() {
		return count;
	}
	public float getPercentage() {
		return percentage;
	}
}
