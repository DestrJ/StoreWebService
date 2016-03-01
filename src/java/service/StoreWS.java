/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Capacitor;
import entities.Orders;
import entities.Resistor;
import entities.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import restfulclient.CapacitorClient;
import restfulclient.OrderClient;
import restfulclient.ResistorClient;
import restfulclient.UserClient;

/**
 *
 * @author Destr
 */
@WebService(serviceName = "StoreWS")
public class StoreWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "getAllUsers")
    public List<User> getAllUsers(){
        UserClient client = new UserClient();
        GenericType<List<User>> gType = new GenericType<List<User>>() {
        };
        Response response = client.findAll_XML(Response.class);
        List<User> users = response.readEntity(gType);
        return users;
    }    
    
    @WebMethod(operationName = "getUser")
    public User getUser(@WebParam(name = "id") Integer id){
        UserClient client = new UserClient();
        User user = client.find_XML(User.class, id.toString());
        return user;
    }
    
    @WebMethod(operationName = "addUser")
    public void addUser(@WebParam(name = "user") User user){
        UserClient client = new UserClient();
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        client.create_XML(user);        
    }
    
    @WebMethod(operationName = "removeUser")
    public void removeUser(@WebParam(name = "id")Integer id){
        UserClient client = new UserClient();
        client.remove(id.toString());
    }
    
    @WebMethod(operationName = "updateUser")
    public void updateUser(@WebParam(name = "id")Integer id, @WebParam(name = "user") User user){
        UserClient client = new UserClient();
        client.edit_XML(user, id.toString());
    }
    
    @WebMethod(operationName = "addCapacitor")
    public void addCapacitor(@WebParam(name = "capacitor")Capacitor capacitor){
        CapacitorClient client = new CapacitorClient();
        client.create_XML(capacitor);       
    }
    
    @WebMethod(operationName = "getCapacitor")
    public Capacitor getCapacitor(@WebParam(name = "id") Integer id){
        CapacitorClient client = new CapacitorClient();
        Capacitor capacitor = client.find_XML(Capacitor.class, id.toString());
        return capacitor;
    }
    
    @WebMethod(operationName = "getAllCapacitors")
    public List<Capacitor> getAllCapacitors(){
        CapacitorClient client = new CapacitorClient();
        GenericType<List<Capacitor>> gType = new GenericType<List<Capacitor>>() {
        };
        Response response = client.findAll_XML(Response.class);
        List<Capacitor> capacitors = response.readEntity(gType);
        return capacitors;
    }
    
    @WebMethod(operationName = "removeCapacitor")
    public void removeCapacitor(@WebParam(name = "id") Integer id){
        CapacitorClient client = new CapacitorClient();
        client.remove(id.toString());
    }
    
    @WebMethod(operationName = "updateCapacitor")
    public void updateCapacitor(@WebParam(name = "id") Integer id, @WebParam(name = "capacitor")Capacitor capacitor){
        CapacitorClient client = new CapacitorClient();
        client.edit_XML(capacitor, id.toString());
    }
    
    @WebMethod(operationName = "addOrder")
    public void addOrder(@WebParam(name = "order")Orders order){
        OrderClient client = new OrderClient();
        client.create_XML(order);       
    }
    
    @WebMethod(operationName = "getOrder")
    public Orders getOrder(@WebParam(name = "id")Integer id){
        OrderClient client = new OrderClient();
        Orders order = client.find_XML(Orders.class, id.toString());
        return order;
    }
    
    @WebMethod(operationName = "getAllOrders")
    public List<Orders> getAllOrders(){
        OrderClient client = new OrderClient();
        GenericType<List<Orders>> gType = new GenericType<List<Orders>>() {
        };
        Response response = client.findAll_XML(Response.class);
        List<Orders> orders = response.readEntity(gType);
        return orders;
    }
    
    @WebMethod(operationName = "updateOrder")
    public void updateOrder(@WebParam(name = "id")Integer id, @WebParam(name = "order") Orders order){
        OrderClient client = new OrderClient();
        client.edit_XML(order, id.toString());
    }
    
    @WebMethod(operationName = "removeOrder")
    public void removeOrder(@WebParam(name = "id")Integer id){
        OrderClient client = new OrderClient();
        client.remove(id.toString());
    }
    
    @WebMethod(operationName = "addResistor")
    public void addResistor(@WebParam(name = "resistor")Resistor resistor){
        OrderClient client = new OrderClient();
        client.create_XML(resistor);      
    }
    
    @WebMethod(operationName = "getResistor")
    public Resistor getResistor(@WebParam(name = "id")Integer id){
        ResistorClient client = new ResistorClient();
        Resistor resistor = client.find_XML(Resistor.class, id.toString());
        return resistor;
    }
    
    @WebMethod(operationName = "getAllResistors")
    public List<Resistor> getAllResistors(){
        ResistorClient client = new ResistorClient();
        GenericType<List<Resistor>> gType = new GenericType<List<Resistor>>() {
        };
        Response response = client.findAll_XML(Response.class);
        List<Resistor> resistors = response.readEntity(gType);
        return resistors;
    }
    
    @WebMethod(operationName = "updateResistor")
    public void updateResistor(@WebParam(name = "id")Integer id,@WebParam(name = "resistor")Resistor resistor){
        OrderClient client = new OrderClient();
        client.edit_XML(resistor, id.toString());
    }
    
    @WebMethod(operationName = "removeResistor")
    public void removeResistor(@WebParam(name = "id")Integer id){
        ResistorClient client = new ResistorClient();
        client.remove(id.toString());
    }
    
    @WebMethod(operationName = "checkAuthorization")
    public User checkAuthorization(@WebParam(name = "user")User user){
        List<User> users = getAllUsers();
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getName().equals(user.getName())){
                if(users.get(i).getPassword().equals(user.getPassword())){
                    return users.get(i);
                }
            }
        }        
        return null;
    }
    
    @WebMethod(operationName = "sortByAscendingCapacitorPrice")
    public List<Capacitor> sortByAscendingCapacitorPrice(){
        List<Capacitor> capacitors = getAllCapacitors();
        boolean flag = true;   
        while(flag){            
            flag = false;
            for(int i=0; i<capacitors.size()-1; i++){
                if(capacitors.get(i).getPrice()>capacitors.get(i+1).getPrice()){
                    Collections.swap(capacitors, i, i+1);
                    flag = true;
                }
            }
        }         
        return capacitors;
    }
    
    @WebMethod(operationName = "sortByDescendingCapacitorPrice")
    public List<Capacitor> sortByDescendingCapacitorPrice(){
        List<Capacitor> capacitors = getAllCapacitors();
        boolean flag = true;   
        while(flag){            
            flag = false;
            for(int i=0; i<capacitors.size()-1; i++){
                if(capacitors.get(i).getPrice()<capacitors.get(i+1).getPrice()){
                    Collections.swap(capacitors, i, i+1);
                    flag = true;
                }
            }
        }         
        return capacitors;
    }
    
    @WebMethod(operationName = "sortByDescendingCapacitorCap")
    public List<Capacitor> sortByDescendingCapacitorCap(){
        List<Capacitor> capacitors = getAllCapacitors();
        boolean flag = true;   
        while(flag){            
            flag = false;
            for(int i=0; i<capacitors.size()-1; i++){
                if(capacitors.get(i).getCapacity()<capacitors.get(i+1).getCapacity()){
                    Collections.swap(capacitors, i, i+1);
                    flag = true;
                }
            }
        }         
        return capacitors;
    }
    
    @WebMethod(operationName = "sortByAscendingCapacitorCap")
    public List<Capacitor> sortByAscendingCapacitorCap(){
        List<Capacitor> capacitors = getAllCapacitors();
        boolean flag = true;   
        while(flag){            
            flag = false;
            for(int i=0; i<capacitors.size()-1; i++){
                if(capacitors.get(i).getCapacity()>capacitors.get(i+1).getCapacity()){
                    Collections.swap(capacitors, i, i+1);
                    flag = true;
                }
            }
        }         
        return capacitors;
    }
    
    @WebMethod(operationName = "buyCapacitor")
    public boolean buyCapacitor(@WebParam(name = "idCapacitor")Integer idCap,
                                @WebParam(name = "idUser")Integer idUser,
                                @WebParam(name = "capacitorCount")Integer count){
        Capacitor capacitor = getCapacitor(idCap);
        User user = getUser(idUser);
        if((capacitor.getCount()>0)&&(capacitor.getCount()>count)){
            Orders order = new Orders();
            order.setUserId(user.getId());
            order.setUserName(user.getName());
            order.setProductId(capacitor.getId());
            order.setProductName(capacitor.getName());
            order.setPrice(capacitor.getPrice()*count);
            order.setCount(count);
            addOrder(order);
            capacitor.setCount(capacitor.getCount()-count);
            updateCapacitor(capacitor.getId(), capacitor);
            return true;
        }
        return false;
    }
    
}
