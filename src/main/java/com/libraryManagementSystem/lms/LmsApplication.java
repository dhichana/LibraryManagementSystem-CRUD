package com.libraryManagementSystem.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@SpringBootApplication
public class LmsApplication {
	static Scanner in = new Scanner(System.in);
	static List<Books> list = new ArrayList<>();
	public static void main(String[] args) {
		list.add(new Books("Java", "Abc"));
		System.out.println("---------------------------");
		System.out.println("|LIBRARY MANAGEMENT SYSTEM|");
		System.out.println("---------------------------");

//		SpringApplication.run(LmsApplication.class, args);
		while(true){
			System.out.println("1.Get all books in Library");
			System.out.println("2.Get Book by Id");
			System.out.println("3.Add Books to Library");
			System.out.println("4.Update a book in Library");
			System.out.println("5.Delete book in Library");
			System.out.println("6.Quit");
			System.out.println();
			int choice  = in.nextInt();
			switch (choice){
				case 1:
					getAllBooks();
					System.out.println();
					break;
				case 2:
					System.out.print("Enter the book id for the book need to be searched: ");
					getBookById(in.nextLong());
					System.out.println();
					break;
				case 3:
					System.out.print("Enter no of books to be added: ");
					addBooks(in.nextInt());
					System.out.println();
					break;
				case 4:
					System.out.print("Enter the id of the book to be updated: ");
					updateBooks(in.nextLong());
					System.out.println();
					break;
				case 5:
					System.out.print("Enter the id of the book to be deleted: ");
					deleteBooks(in.nextLong());
					System.out.println();
					break;
				case 6:
					System.exit(0);
			}
		}
	}

	public static void getAllBooks(){
		for(Books book: list){
			System.out.println(book);
		}
	}

	public static void getBookById(Long id){
		for(Books book: list){
			if(Objects.equals(book.getId(), id)){
				System.out.println(book);
				return;
			}
		}
		System.out.println("No book found");
	}

	public static void addBooks(int count){
		in.nextLine();
		for(int i = 1; i <= count; i++){
			System.out.println("You are adding Book" + i + "provide the title and author:");
			Books b1 = new Books(in.nextLine(), in.nextLine());
			list.add(b1);
		}
	}

	public static void updateBooks(Long id){
		in.nextLine();
		for(Books book: list){
			if(Objects.equals(book.getId(), id)){
				System.out.println("Update the changes of title-1 and author-2");
				int choice = in.nextInt();
				in.nextLine();
				if(choice == 1) {
					book.setTitle(in.nextLine());
				}else{
					book.setAuthor(in.nextLine());
				}
				return;
			}
		}
		System.out.println("No book found");
	}

	public static void deleteBooks(Long id){
		in.nextLine();
		for(Books book: list){
			if(Objects.equals(book.getId(), id)){
				list.remove(book);
				updateIds(book.getId());
				System.out.println("Book has been deleted successfully");
				return;
			}
		}
		System.out.println("No book found");
	}

	public static void updateIds(Long id){
		for(Books book: list){
			if(book.getId() > id){
				book.setId(book.getId()-1);
			}
		}
	}


}
