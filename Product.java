package com.khubaib;

//abstract class Product
public abstract class Product {

    //Declaring instance variables
    double regularPrice;

    //constructor Product
    Product(double regularPrice){
        this.regularPrice = regularPrice;
    }


    public abstract double computeSalePrice();

    //getter for RegularPrice
    public double getRegularPrice() {
        return regularPrice;
    }

    //setter for RegularPrice (not used)
    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }
}

//abstract class Electronics inheriting abstract Class Product
abstract class Electronics extends Product{

    //Declaring Instance Variable
    String manufacturer;

    //constructor Electronics
    Electronics(double regularPrice, String manufacturer){
        super(regularPrice);
        this.manufacturer = manufacturer;
    }

    //getter for Manufacturer (not used)
    public String getManufacturer() {
        return manufacturer;
    }

    //setter for Manufacturer (not used)
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}

//Concrete class Book1 inheriting abstract class Product
class Book extends Product{

    //Declaring Instance Variables
    String publisher;
    int yearPublished;

    //constructor Book1
    Book (double regularPrice, String publisher, int yearPublished){
        super(regularPrice);
        this.publisher = publisher;
        this.yearPublished = yearPublished;
    }

    //calculates the Sale Price of Book at 50% discount
    public double computeSalePrice() {
        return (0.5)*getRegularPrice();
    }

    //getter for the Publisher (not used)
    public String getPublisher() {
        return publisher;
    }

    //setter for the Publisher (not used)
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    //getter for the Year Published (not used)
    public int getYearPublished() {
        return yearPublished;
    }

    //setter for the Year Published (not used)
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
}

//Concrete class MP3 player inheriting the abstract class Electronics
class MP3Player extends Electronics{

    //Declaring instance variable
    String color;

    //constructor MP3Player
    MP3Player(double regularPrice, String manufacturer, String color){
        super(regularPrice, manufacturer);
        this.color = color;
    }

    //calculates discount price of MP3 Player at 10% discount
    public double computeSalePrice() {
        return (0.9)*getRegularPrice();
    }

    //getter for color (not used)
    public String getColor() {
        return color;
    }

    //setter for color (not used)
    public void setColor(String color) {
        this.color = color;
    }

}

//Concrete class TV inheriting abstract class Electronics
class TV extends Electronics{

    //Declaring instance variable
    int size;

    //constructor TV
    TV(double regularPrice, String manufacturer, int size){
        super(regularPrice, manufacturer);
        this.size = size;
    }

    //calculates discounted price of TV at 20% discount
    public double computeSalePrice() {
        return (0.8)*getRegularPrice();
    }
}



class ProductTesting {

    public static void main(String[] args) {

        // Declare and create Product array of size 5
        Product[] pa = new Product[5];

        // Create object instances and assign them to
        // the type of Product.
        pa[0] = new TV( 1000, "Samsung", 30);
        pa[1] = new TV( 2000, "Sony", 50);
        pa[2] = new MP3Player( 250, "Apple", "blue");
        pa[3] = new Book( 34, "Sun press", 1992);
        pa[4] = new Book( 15, "Korea press", 1986);

        // Compute total regular price and total
        // sale price.
        double totalRegularPrice = 0;
        double totalSalePrice    = 0;

        for (int i=0; i<pa.length; i++){

            // Call a method of the super class to get
            // the regular price.
            totalRegularPrice += pa[i].getRegularPrice();

            // Since the sale price is computed differently
            // depending on the product type, overriding (implementation)
            // method of the object instance of the sub-class
            // gets invoked.  This is runtime polymorphic
            // behavior.
            totalSalePrice += pa[i].computeSalePrice();

            System.out.println("Item number " + i +
                    ": Type = "          + pa[i].getClass().getName() +
                    ", Regular price = " + pa[i].getRegularPrice() +
                    ", Sale price = "    + pa[i].computeSalePrice());
        }

        System.out.println("totalRegularPrice = " + totalRegularPrice);
        System.out.println("totalSalePrice = "    + totalSalePrice);
    }
}

