package cz.asseco.tutorial.rest;

import cz.asseco.tutorial.dto.PobockaDto;
import cz.asseco.tutorial.service.PobockaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/pobocka")
@RequiredArgsConstructor
public class PobockaController {
    private final PobockaService pobockaService;

    @GetMapping("/get-all")
    public ResponseEntity<ArrayList<PobockaDto>> getAll() {
        ArrayList<PobockaDto> data = pobockaService.getAll();

        if (CollectionUtils.isEmpty(data)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<Long> insertPobocka(@RequestBody PobockaDto dto) {
        Long id = pobockaService.insert(dto);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
