package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMARY:\n");
        sb.append("Order Moment: ");
        sb.append(sdf.format(moment)+"\n");
        sb.append("Status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client.toString()+"\n");
        sb.append("Order Items: \n");
        for(OrderItem cadaOi:listItem){
            sb.append(cadaOi.toString()+"\n");
        }
        sb.append("Total Price: " + total());
        return sb.toString();
    }

    private Client client;

    private List<OrderItem> listItem = new ArrayList<>();

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem Od){
        this.listItem.add(Od);
    }
    public void removeItem(OrderItem Od){
        this.listItem.remove(Od);
    }

    public Double total(){
        double sum =0;
        for(OrderItem cadaItem:listItem){
            sum+=cadaItem.subTotal();
        }
        return sum;
    }


}
