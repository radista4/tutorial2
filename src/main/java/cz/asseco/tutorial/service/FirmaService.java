package cz.asseco.tutorial.service;

import cz.asseco.tutorial.dto.FirmaDto;
import cz.asseco.tutorial.entity.Firma;
import cz.asseco.tutorial.repository.FirmaRepository;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FirmaService {
    private final FirmaRepository firmaRepository;
    private final Mapper dozerMapper;

    public ArrayList<FirmaDto> getAll() {
        List<Firma> data = firmaRepository.findAll();
        ArrayList<FirmaDto> mappedData = new ArrayList<>();

        if (data == null || data.isEmpty()) {
            return new ArrayList<>();
        }

        for (Firma firma : data) {
            if (firma != null) {
                mappedData.add(dozerMapper.map(firma, FirmaDto.class));
            }
        }

        return mappedData;
    }

    public long insert(FirmaDto dto) {
        Firma insertFirma = firmaRepository.save(dozerMapper.map(dto, Firma.class));
        return insertFirma.getId();
    }
}
