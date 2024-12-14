package pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.response;

import pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.dto.Dto;

public record FindAllResponse(String code,
                              String error,
                              Iterable<Dto> cars) {
}
