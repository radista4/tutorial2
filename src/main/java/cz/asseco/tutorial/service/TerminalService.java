package cz.asseco.tutorial.service;

import cz.asseco.tutorial.dto.TerminalDto;
import cz.asseco.tutorial.entity.Terminal;
import cz.asseco.tutorial.repository.TerminalRepository;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TerminalService {
    private final TerminalRepository terminalRepository;
    private final Mapper dozerMapper;

    public ArrayList<TerminalDto> getAll() {
        List<Terminal> data = terminalRepository.findAll();
        ArrayList<TerminalDto> mappedData = new ArrayList<>();

        for (Terminal terminal: data) {
            mappedData.add(dozerMapper.map(terminal, TerminalDto.class));
        }

        return mappedData;
    }
}
