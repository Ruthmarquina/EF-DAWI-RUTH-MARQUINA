package pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.service;

import pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.dto.DatailDto;
import pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.dto.Dto;
import pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.dto.UpdateDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {
    List<Dto> getAllCars() throws Exception;

    Optional<DatailDto> getCarById(int id) throws Exception;

    boolean updateCar(UpdateDto UpdateDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(DatailDto DetailDto) throws Exception;
}
