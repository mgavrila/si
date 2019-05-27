package ro.ugal.si.model;

public class Cart {

	private int idCart;
	private int idProduct;
	private int idUser;
	private Product customProduct;
	private User customUser;
	
	public Cart(int idProduct, int idUser) {
		this.idProduct = idProduct;
		this.idUser = idUser;
	}
	
	public int getIdCart() {
		return idCart;
	}
	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Product getCustomProduct() {
		return customProduct;
	}

	public void setCustomProduct(Product customProduct) {
		this.customProduct = customProduct;
	}

	public User getCustomUser() {
		return customUser;
	}

	public void setCustomUser(User customUser) {
		this.customUser = customUser;
	}

	@Override
	public String toString() {
		return "Cart [customProduct=" + customProduct + ", customUser=" + customUser + "]";
	}

	
	
	
}
