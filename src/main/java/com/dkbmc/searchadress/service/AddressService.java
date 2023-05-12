package com.dkbmc.searchadress.service;

import com.dkbmc.searchadress.domain.Address;
import com.dkbmc.searchadress.dto.AddressDTO;
import com.dkbmc.searchadress.dto.ResponseDTO;
import com.dkbmc.searchadress.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public int saveAddress(AddressDTO.RequestSave request) {
       Address address =  addressRepository.save(request.toEntity());
        if (address.getId() != null) {
            result = 1;
        }
        return result;
    }

    public ResponseDTO saveAddressRes(AddressDTO.RequestSave request) {
        int res = saveAddress(request);
        if (res == 1) {
            responseDTO = ResponseDTO.builder()
                    .result(res)
                    .return_msg("성공적으로 주소 저장 완료")
                    .build();
        } else {
            responseDTO = ResponseDTO.builder()
                    .error_code("500")
                    .error_msg("주소 저장 실패")
                    .build();
        }
        return responseDTO;
    }
}
