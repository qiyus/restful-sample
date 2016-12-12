package com.vigorx.news;

/**
 * 通知列表JSON
 * 
 * @author songlei
 */
public class DynamicResult {

	private String id;
	private String organid;
	private String title;
	private String publishTime;

	/**
	 * @return the infoid
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param infoid
	 *            the infoId to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the organid
	 */
	public String getOrganid() {
		return organid;
	}

	/**
	 * @param organid
	 *            the organid to set
	 */
	public void setOrganid(String organid) {
		this.organid = organid;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the publishedTime
	 */
	public String getPublishTime() {
		return publishTime;
	}

	/**
	 * @param publishedTime
	 *            the publishedTime to set
	 */
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

}
