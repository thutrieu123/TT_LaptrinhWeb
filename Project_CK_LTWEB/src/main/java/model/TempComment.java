package model;

public class TempComment {
	private int userId;
	private int productId;
	private String name;
	private String comment;
	private String time;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public TempComment(int userId, int productId, String name, String comment, String time) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.name = name;
		this.comment = comment;
		this.time = time;
	}

	@Override
	public String toString() {
		return "TempComment [userId=" + userId + ", productId=" + productId + ", name=" + name + ", comment=" + comment
				+ ", time=" + time + "]";
	}

}
