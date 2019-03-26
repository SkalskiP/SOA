package books.utils;

import books.domain.Book;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BookUtil {
    public static ArrayList<Book> loadDataFromCsv(String path) {
        ArrayList<Book> books = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        try {
            br = new BufferedReader(new FileReader(path));
            br.readLine(); // to rid of headers
            int id = 0;
            while ((line = br.readLine()) != null) {

                String[] bookCsv = line.split(cvsSplitBy);

                Book book = new Book();
                book.setId(id);
                book.setTitle(bookCsv[0]);
                book.setAuthor(bookCsv[1]);
                book.setCategory(bookCsv[2]);
                book.setPages(bookCsv[3]);
                book.setPrice(Double.parseDouble(bookCsv[5]));
                book.setCurrency(bookCsv[6]);

                books.add(book);
                id++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return books;
    }

    public static ArrayList<Book> bookArrayCopy(ArrayList<Book> bookArray) {
        ArrayList<Book> books = new ArrayList<>();
        for (Book book : bookArray) {
            books.add(book.copy());
        }
        return books;
    }
}
