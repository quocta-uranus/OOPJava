
# OOP

***Attribute***
Là những thông tin về đặc điểm đối tượng 

***Methods*** 
Là những hành vi mà đối tượng thực hiện

*Example:* 

**Điện thoại**

*Atribute* : Màu sắc, kích thước, bộ nhớ,...

*Methods* : Nghe, gọi, chụp ảnh, nhắn tin,...

**Con người** :

*Atribute* : Tên, tuổi, địa chỉ,..

*Methods* : Đi , đứng, làm việc, ăn, ngủ,...

***Class***
Là những đối tượng có đặc tính tương tự nhau sẽ được tập hợp thành một lớp

*Example* 

```Java
class Student {

    int id;
    String name;
    String address;
}
```
### 4 đặc tính cơ bản của OOP
##### **1. Tính đóng gói** 
Tính đóng gói cho phép che giấu thông tin và những tính chất xử lý bên trong của đối tượng

* ***Public*** :  những phương thức hoặc biến với kiểu dữ liệu này sẽ được truy xuất và sử dụng ở đâu cũng được.

* ***Private***:  những phương thức hoặc biến với kiểu dữ liệu này sẽ được truy xuất và sử dụng trong nội bộ của Class nơi mà phương thức hoặc biến đó được khai báo.

* ***Protected***: những phương thức hoặc biến với kiểu dữ liệu này ngoài việc sử dụng trong nội bộ Class, chúng còn có thể được truy xuất ở Class con kế thừa Class khai báo hàm hoặc phương thức đó.

```java
public class Car {
    public String brand;
    private double price;
    protected int year;

    public Car(String brand, double price, int year) {
        this.brand = brand;
        this.price = price;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Price: $" + price);
        System.out.println("Year: " + year);
    }

    private void calculateDepreciation() {
       double depreciationRate = 0.1; 
        double depreciationAmount = price * depreciationRate;
        price -= depreciationAmount;
        System.out.println("Depreciation calculated. New price: $" + price);
    }

    protected void increaseYear() {
        year++;
    }
}
```
##### **2. Tính kế thừa** 
Tính kế thừa cho phép xây dụng một lớp mới (lớp Con), kế thừa và tái sử dụng các thuộc tính phương thức dựa trên lớp cũ (lớp Cha) đã có trước đó.
```java
class Animal {
    String name;
    public Animal(String name) {
        this.name = name;
    }
    public void eat() {
        System.out.println(name + " is eating.");
    }
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}
class Dog extends Animal {
    public Dog(String name) {
        super(name); 
    }
    
    public void bark() {
        System.out.println(name + " is barking.");
    }
}
public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy");
        myDog.eat(); 
        myDog.sleep(); 
        myDog.bark(); 
    }
}
```
##### **3. Tính đa hình** 
Tính đa hình trong lập trình OOP cho phép các đối tượng khác nhau thực thi chức năng giống nhau theo những cách khác nhau

```java
class Animal {
    String name;
    int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void makeSound() {
        System.out.println(name + " makes a sound.");
    }
}
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " barks.");
    }
}
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age); 
    }
    @Override
    public void makeSound() {
        System.out.println(name + " meows.");
    }
}
public class Main {
    public static void main(String[] args) {

        Animal[] animals = new Animal[2];
        animals[0] = new Dog("Buddy", 3);
        animals[1] = new Cat("Whiskers", 5);
        for (Animal animal : animals) {
            animal.makeSound(); 
        }
    }
}
```
##### **4. Tính  trừu tượng** 
Tính trừu tượng giúp loại bỏ những thứ phức tạp không cần thiết của đối tượng và chỉ tâp trung vào những thứ cốt lõi quan trọng
```java
abstract class Animal {
    private String name;
    public Animal(String name) {
        this.name = name;
    }
    public abstract void makeSound();
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }
}
public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Whiskers");
        dog.makeSound(); 
        dog.sleep();     
        cat.makeSound(); 
        cat.sleep();     
    }
}

```

