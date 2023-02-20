package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {

    private List<Car> carList;

    {
        carList = new ArrayList<>();

        carList.add(new Car("Audi", 1111, "White"));
        carList.add(new Car("Toyota", 2222, "Red"));
        carList.add(new Car("BMW", 3333, "Blue"));
        carList.add(new Car("Mercedes", 4444, "Black"));
        carList.add(new Car("Renault", 5555, "Yellow"));
    }

    public List<Car> getCarsByNumber (int number) {
        return carList.stream().limit(number).collect(Collectors.toList());
    }

}
