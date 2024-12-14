package pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.dto.DatailDto;
import pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.dto.Dto;
import pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.dto.UpdateDto;
import pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.entity.Car;
import pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.repository.CarRepository;
import pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.service.ManageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {
    @Autowired
    CarRepository carRepository;

    @Override
    public List<Dto> getAllCars() throws Exception {
        List<Dto> cars = new ArrayList<Dto>();
        Iterable<Car> iterable = carRepository.findAll();

        iterable.forEach(car -> {
            cars.add(new Dto(
                    car.getCar_id(),
                    car.getModel(),
                    car.getYear(),
                    car.getMileage(),
                    car.getColor()
            ));
        });

        return cars;
    }

    @Override
    public Optional<DatailDto> getCarById(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new DatailDto(
                car.getCar_id(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicense_plate(),
                car.getOwner_name(),
                car.getOwner_contact(),
                car.getPurchase_date(),
                car.getMileage(),
                car.getEngine_type(),
                car.getColor(),
                car.getInsurance_company(),
                car.getInsurance_policy_number(),
                car.getRegistration_expiration_date(),
                car.getService_due_date()
        ));
    }

    @Override
    public boolean updateCar(UpdateDto UpdateDto) throws Exception {
        Optional<Car> optional = carRepository.findById(UpdateDto.car_id());
        return optional.map(car -> {
            car.setMake(UpdateDto.make());
            car.setModel(UpdateDto.model());
            car.setYear(UpdateDto.year());
            car.setOwner_name(UpdateDto.owner_name());
            car.setColor(UpdateDto.color());

            carRepository.save(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteCarById(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean addCar(DatailDto DetailDto) throws Exception {
        Optional<Car> optional = carRepository.findById(DetailDto.car_id());

        if (optional.isPresent()) {
            return false;
        } else {
            Car car = new Car();
            car.setMake(DetailDto.make());
            car.setModel(DetailDto.model());
            car.setYear(DetailDto.year());
            car.setVin(DetailDto.vin());
            car.setLicense_plate(DetailDto.license_plate());
            car.setOwner_name(DetailDto.owner_name());
            car.setOwner_contact(DetailDto.owner_contact());
            car.setPurchase_date(DetailDto.purchase_date());
            car.setMileage(DetailDto.mileage());
            car.setEngine_type(DetailDto.engine_type());
            car.setColor(DetailDto.color());
            car.setInsurance_company(DetailDto.insurance_company());
            car.setInsurance_policy_number(DetailDto.insurance_policy_number());
            car.setRegistration_expiration_date(DetailDto.registration_expiration_date());
            car.setService_due_date(DetailDto.service_due_date());
            carRepository.save(car);
            return true;
        }
    }
}
