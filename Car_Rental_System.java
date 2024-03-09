import java.util.ArrayList;
import java.util.Scanner;

class Car {

    private String model;
    private String color;
    private boolean available;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
        this.available = true;
    }

    public String getModel() {
        return model;
    }
    public String getColor(){
        return color;
    }
    public boolean isAvailable()
    {
        return available;
    }
    public void rentCar(){
        available=false;

    }
    public void returnCar(){
        available=true;
    }
}

 class carRental {
    private ArrayList<Car> cars;

    public carRental() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void displayAvailableCars() {
        System.out.println("available cars");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println("Model:" + car.getModel() + ",Color:" + car.getColor());
            }
        }
        System.out.println("---------------------------");
    }

    public Car rentCar(String model) {
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && car.isAvailable()) {
                car.rentCar();
                return car;
            }

        }
        return null;
    }

    public void returnCar(Car car) {
        car.returnCar();
        System.out.println("Car returned successfully");
    }

}

public class Car_Rental_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        carRental rentalSystem = new carRental();

        rentalSystem.addCar(new Car("toyota -sedan", "Black"));
        rentalSystem.addCar(new Car("maruti and suzuki -swift", "white"));
        rentalSystem.addCar(new Car("toyota -innova", "white"));
        rentalSystem.addCar(new Car("hyundai -grand i10", "grey"));
        while (true) {
            System.out.println("1: Display cars");
            System.out.println("2: Rent a car");
            System.out.println("3: Return a car");
            System.out.println("4: exit");
            System.out.println("eneter your choice");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    rentalSystem.displayAvailableCars();
                    break;
                case 2:
                    System.out.println("enter the car model to rent");
                    String rentModel = sc.nextLine();
                    Car rentedCar = rentalSystem.rentCar(rentModel);
                    if (rentedCar != null) {
                        System.out.println("car rented successfully" + rentedCar.getModel());
                    } else {
                        System.out.println("car not available");
                    }
                    break;

                case 3:
                    System.out.println("enter car model to return");
                    String returnModel = sc.nextLine();
                    Car carToReturn = rentalSystem.rentCar(returnModel);
                    if (carToReturn != null) {
                        rentalSystem.returnCar(carToReturn);
                    } else {
                        System.out.println("car does not exist");
                    }
                    break;
                case 4:
                    System.out.println("Exiting.....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid choice");

            }

        }
    }

}