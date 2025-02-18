/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;


public interface DAOInterface<D> {  //<D> trong khai báo giao diện DAOInterface<D> là một loại tham số tổng quát (generic type parameter). Điều này có nghĩa là giao diện DAOInterface có thể làm việc với bất kỳ loại đối tượng nào, không bị giới hạn bởi một loại cụ thể.
    public ArrayList<D> getAll();
    
    public boolean has(String d);
    
    public boolean add(D d);
    
    public boolean delete(String d);
    
    public boolean update(D d);
    
    public D getByID(String d);
    
    public ArrayList<D> search(String d);
}
