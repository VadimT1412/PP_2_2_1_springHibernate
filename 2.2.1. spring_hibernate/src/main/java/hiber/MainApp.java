package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");

        user1.setCar(new Car("X5", 2020));
        user2.setCar(new Car("X6", 2021));
        user3.setCar(new Car("X7", 2022));
        user4.setCar(new Car("X8", 2023));

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
        }
        List<Car> cars = userService.listCars();
        for (Car car : cars) {
            System.out.println("Car Id = " + car.getId());
            System.out.println("Car Model = " + car.getModel());
            System.out.println("Car Series = " + car.getSeries());
        }
        System.out.println(userService.carList("X8", 2023));

        context.close();
    }
}
