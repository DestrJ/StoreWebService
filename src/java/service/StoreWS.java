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
    
    @WebMethod(operationName = "addCapacitor")
    public void addResistor(@WebParam(name = "capacitor")Resistor resistor){
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
    
//    @WebMethod(operationName = "sortByAscendingCapacitorPrice")
//    public List<User> sortByAscendingCapacitorPrice(@WebParam(name = "users") List<User> users){
//        boolean flag = true;   
//          
//        
//        
//        return null;
//    }
    
    
}
