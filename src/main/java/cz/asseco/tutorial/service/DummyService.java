package cz.asseco.tutorial.service;

import cz.asseco.tutorial.dto.DummyDto;
import cz.asseco.tutorial.entity.Dummy;
import cz.asseco.tutorial.repository.DummyRepository;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DummyService {
    private final DummyRepository dummyRepository;
    private final Mapper dozerMapper;

    public ArrayList<DummyDto> getAll() {
        List<Dummy> data = dummyRepository.findAll();
        ArrayList<DummyDto> mappedData = new ArrayList<>();

        for (Dummy dummy : data) {
            mappedData.add(dozerMapper.map(dummy, DummyDto.class));
        }

        return mappedData;
    }

    public long saveData(DummyDto dto) {
        Dummy saveDumy = dummyRepository.save(dozerMapper.map(dto, Dummy.class));
        return saveDumy.getId();
    }
}
