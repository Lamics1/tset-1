package com.example.project1.Service;


import com.example.project1.Model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ServiceBook {

    ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> getAll(Book book) {
        ArrayList<Book> result = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            result.add(book);
        }
        return result;
    }

    public void add(Book book){

       books.add(book);

    }

    public boolean delete(String id){

        for (int i = 0; i<books.size();i++){
            if (books.get(i).equals(id)){
                books.remove(id);
                return true;

            }
        }
        return false;
    }

    public boolean update(String id){

        for (int i = 0; i<books.size();i++){
            if (books.get(i).equals(id)){
                books.get(i).setId(id);
                return true;

            }
        }
        return false;
    }

}
