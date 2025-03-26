package cz.asseco.tutorial.rest;

import cz.asseco.tutorial.dto.FirmaDto;
import cz.asseco.tutorial.service.FirmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/firma")
@RequiredArgsConstructor
public class FirmaController {
    private final FirmaService firmaService;

    @GetMapping("/get-all")
    public ResponseEntity<ArrayList<FirmaDto>> getAll() {
        ArrayList<FirmaDto> data = firmaService.getAll();

        if (CollectionUtils.isEmpty(data)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<Long> insertFirma(@RequestBody FirmaDto dto) {
        Long id = firmaService.insert(dto);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
