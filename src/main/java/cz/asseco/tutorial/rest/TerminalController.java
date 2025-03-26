package cz.asseco.tutorial.rest;

import cz.asseco.tutorial.dto.TerminalDto;
import cz.asseco.tutorial.service.TerminalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/terminal")
@RequiredArgsConstructor
public class TerminalController {
    private final TerminalService terminalService;

    @GetMapping("/get-all")
    public ResponseEntity<ArrayList<TerminalDto>> getAll() {
        ArrayList<TerminalDto> data = terminalService.getAll();

        if (CollectionUtils.isEmpty(data)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<Long> insertTerminal(@RequestBody TerminalDto dto) {
        Long id = terminalService.insert(dto);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
