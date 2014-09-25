package foo.bar.customer.dao;


import foo.bar.customer.model.Customer;

public interface CustomerDAO {

    public void insert(Customer customer);
    public Customer findByID(int id);

}
