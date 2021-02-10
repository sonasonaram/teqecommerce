package teqecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int userid;
	private long productid;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public long getProductid() {
		return productid;
	}



	public void setProductid(long productid) {
		this.productid = productid;
	}



	@Override
	public String toString() {
		return "Cart [id=" + id + ", userid=" + userid + ", productid=" + productid + "]";
	}
	
}
