package cz.asseco.tutorial.rest;

import cz.asseco.tutorial.dto.DummyDto;
import cz.asseco.tutorial.service.DummyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController()
@RequiredArgsConstructor
public class DummyRest {
    private final DummyService dummyService;

    @GetMapping("/get-all")
    public ResponseEntity<ArrayList<DummyDto>> getAll() {
        ArrayList<DummyDto> data = dummyService.getAll();

        if (CollectionUtils.isEmpty(data)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/save-data")
    public ResponseEntity<Long> saveData(@RequestBody DummyDto dto) {
        Long id = dummyService.saveData(dto);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
