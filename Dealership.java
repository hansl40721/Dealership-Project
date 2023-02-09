public class Dealership {
    private Car[] cars;

    public Dealership(Car[] cars) {
        this.cars = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            this.cars[i] = new Car(cars[i]);
        }
    }

    public void setCar(Car car, int index) {
        this.cars[index] = new Car(car);
    }

    public Car getCar(int index) {
        return new Car(this.cars[index]);
    }

    public void sell(int index) {
        this.cars[index].drive();
        this.cars[index] = null;
    }

    public int search(String make, int budget) {
        for (int i = 0; i < this.cars.length; i++) {
            if (this.cars[i] == null) {
                continue;
            } else if (this.cars[i].getMake().equalsIgnoreCase(make)) {
                 System.out.println("\nWe found one in spot " + i + "\n\n" + this.cars[i].toString());
                 if(this.cars[i].getPrice() <= budget) {
                    System.out.println("This vehicle is within your budget. Are you interested?");
                    return i;
                 } else {
                    System.out.println("Unfortunately, this vehicle is outside of your budget.");
                    return -1;
                 }
            }
        }
        System.out.println("Your search didn't match any results.\n");
        return -1;

    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.cars.length; i++) {
            temp += "Parking Spot: " + i + 1 + "\n";
            if (this.cars[i] == null) {
                temp += "Empty\n";
            } else {
                temp += this.cars[i].toString() + "\n";
            }
        }
        return temp;
    }


}
