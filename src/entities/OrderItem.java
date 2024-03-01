package entities;

public class OrderItem {

    private Integer quantity;

    private Product product;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderItem(){

    }
    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    @Override
    public String toString() {
        return product.toString() + ", Quantity: "+quantity+", Subtotal: $"+String.format("%.2f",subTotal());

    }

    public Double subTotal(){
        return quantity*product.getPrice();
    }

}
