package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "cars", params = {"locale"})
    public String printCar(ModelMap modelMap, @RequestParam("locale") String locale) {
        List<Car> carList = new ArrayList<>(carService.getAllCarWhereName("BMW"));
        if(locale.equals("en")){
            modelMap.addAttribute("locale", "CARS");
        }else{
            modelMap.addAttribute("locale", "МАШИНЫ");
        }
        modelMap.addAttribute("car", carList);
        return "cars";
    }


}
