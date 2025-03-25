package cz.asseco.tutorial.service;

import cz.asseco.tutorial.repository.PobockaRepository;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PobockaService {
    private final PobockaRepository pobockaRepository;
    private final Mapper dozerMapper;
}
