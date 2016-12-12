package com.vigorx.dbentity;

/**
 * NewsDBEntity
 * 
 * @author songlei
 */
public class NewsDBEntity {

	private String infoId;
	private String title;
	private String detail;
	private int type;
	private String publishTime;
	private String organid;

	/**
	 * @return the infoId
	 */
	public String getInfoId() {
		return infoId;
	}

	/**
	 * @param infoId
	 *            the infoId to set
	 */
	public void setInfoId(String infoId) {
		this.infoId = infoId;
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
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * @param detail
	 *            the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the publishTime
	 */
	public String getPublishTime() {
		return publishTime;
	}

	/**
	 * @param publishTime
	 *            the publishTime to set
	 */
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
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

}
