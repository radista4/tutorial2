package cz.asseco.tutorial.rest;

import cz.asseco.tutorial.dto.FirmaDto;
import cz.asseco.tutorial.service.FirmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class FirmaController {
private final FirmaService firmaService;
    @GetMapping("/firma/get-all")
    public ResponseEntity<ArrayList<FirmaDto>> getAll() {
        ArrayList<FirmaDto> data = firmaService.getAll();


        if (CollectionUtils.isEmpty(data)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/firma/insert")
    public ResponseEntity<Long> insertData(@RequestBody FirmaDto dto) {
        Long id = firmaService.insert(dto);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
