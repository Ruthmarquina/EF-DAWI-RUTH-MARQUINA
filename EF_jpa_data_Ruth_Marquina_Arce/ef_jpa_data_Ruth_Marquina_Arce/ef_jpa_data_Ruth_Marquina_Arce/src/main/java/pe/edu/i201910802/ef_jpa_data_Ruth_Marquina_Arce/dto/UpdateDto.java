package pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.dto;

public record UpdateDto(Integer car_id,
                        String make,
                        String model,
                        Integer year,
                        String owner_name,
                        String color) {
}
