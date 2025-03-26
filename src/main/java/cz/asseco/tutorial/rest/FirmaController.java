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

    @GetMapping("/find-by-ico/{ico}")
    public ResponseEntity<ArrayList<FirmaDto>> findByIco(@PathVariable String ico) {
        // TODO kontrola validace vstupu
        ArrayList<FirmaDto> data = firmaService.findByIco(ico);

        if (CollectionUtils.isEmpty(data)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<FirmaDto> findById(@PathVariable Long id) {
        // TODO kontrola validace vstupu
        FirmaDto data = firmaService.findById(id);

        if (data == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
