package model.api;

public class Transport {
	private String order_id;
	private String id;
	private int fee;
	private Date create;
	private Date update;
	private boolean active;

	public Transport(String id, int fee, Date create, Date update) {
		super();
		this.id = id;
		this.fee = fee;
		this.create = create;
		this.update = update;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getOrder_id() {
		return order_id;
	}

	public String getId() {
		return id;
	}

	public int getFee() {
		return fee;
	}

	public Date getCreate() {
		return create;
	}

	@Override
	public String toString() {
		return "Transport [, id=" + id + ", fee=" + fee + ", create=" + create + ", update=" + update +"]" ;
	}

	
}
