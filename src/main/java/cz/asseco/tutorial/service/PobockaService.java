package cz.asseco.tutorial.service;

import cz.asseco.tutorial.dto.PobockaDto;
import cz.asseco.tutorial.entity.Pobocka;
import cz.asseco.tutorial.repository.PobockaRepository;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PobockaService {
    private final PobockaRepository pobockaRepository;
    private final Mapper dozerMapper;

    @Transactional
    public ArrayList<PobockaDto> getAll() {
        List<Pobocka> data = pobockaRepository.findAll();
        ArrayList<PobockaDto> mappedData = new ArrayList<>();

        for (Pobocka pobocka : data) {
            mappedData.add(dozerMapper.map(pobocka, PobockaDto.class));
        }

        return mappedData;
    }

    @Transactional
    public long insert(PobockaDto dto) {
        Pobocka insertedPobocka = pobockaRepository.save(dozerMapper.map(dto, Pobocka.class));
        return insertedPobocka.getId();
    }

    @Transactional
    public PobockaDto findById(Long id) {
        Optional<Pobocka> optionalPobocka = pobockaRepository.findById(id);

        if (optionalPobocka.isEmpty()) {
            return null;
        }
        Pobocka pobocka = optionalPobocka.get();

        return dozerMapper.map(pobocka, PobockaDto.class);
    }
}
