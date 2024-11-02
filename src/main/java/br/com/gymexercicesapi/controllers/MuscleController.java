package br.com.gymexercicesapi.controllers;

import br.com.gymexercicesapi.models.dto.request.MuscleRequest;
import br.com.gymexercicesapi.models.dto.response.MuscleResponse;
import br.com.gymexercicesapi.services.MuscleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/muscle")
public class MuscleController {
    private final MuscleService muscleService;

    public MuscleController(MuscleService muscleService){
        this.muscleService = muscleService;
    }

    @PostMapping()
    public ResponseEntity<Void> save (@RequestBody MuscleRequest muscleRequest){
        muscleService.save(muscleRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idMuscle}")
    public ResponseEntity<MuscleResponse> getById (@PathVariable Long idMuscle){
        return ResponseEntity.ok().body(muscleService.getById(idMuscle));
    }

    @GetMapping("/{nameMuscle}")
    public ResponseEntity<MuscleResponse> getByName (@PathVariable String nameMuscle){
        return ResponseEntity.ok().body(muscleService.getByName(nameMuscle));
    }

    @PutMapping()
    public ResponseEntity<Void> update (@RequestBody Long idMuscle, MuscleRequest muscleRequest){
        muscleService.update(idMuscle, muscleRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idMuscle}")
    public ResponseEntity<Void> delete (@PathVariable Long idMuscle){
        muscleService.delete(idMuscle);
        return ResponseEntity.ok().build();
    }
}
