package pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.response;

import pe.edu.i201910802.ef_jpa_data_Ruth_Marquina_Arce.dto.DatailDto;

public record FindDetailResponse(String code,
                                 String error,
                                 DatailDto car) {
}
