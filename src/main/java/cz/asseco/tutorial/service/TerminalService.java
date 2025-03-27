package cz.asseco.tutorial.service;

import cz.asseco.tutorial.dto.TerminalDto;
import cz.asseco.tutorial.entity.Terminal;
import cz.asseco.tutorial.repository.TerminalRepository;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TerminalService {
    private final TerminalRepository terminalRepository;
    private final Mapper dozerMapper;

    @Transactional
    public ArrayList<TerminalDto> getAll() {
        List<Terminal> data = terminalRepository.findAll();
        ArrayList<TerminalDto> mappedData = new ArrayList<>();

        for (Terminal terminal : data) {
            mappedData.add(dozerMapper.map(terminal, TerminalDto.class));
        }

        return mappedData;
    }

    @Transactional
    public long insert(TerminalDto dto) {
        Terminal insertedFirma = terminalRepository.save(dozerMapper.map(dto, Terminal.class));
        return insertedFirma.getId();
    }

    @Transactional
    public TerminalDto findById(Long id) {
        Optional<Terminal> optionalTerminal = terminalRepository.findById(id);

        if (optionalTerminal.isEmpty()) {
            return null;
        }
        Terminal terminal = optionalTerminal.get();

        return dozerMapper.map(terminal, TerminalDto.class);
    }
}
