package br.com.gymexercicesapi.controllers;

import br.com.gymexercicesapi.models.dto.request.MuscleGroupRequest;
import br.com.gymexercicesapi.models.dto.response.MuscleGroupResponse;
import br.com.gymexercicesapi.services.MuscleGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/muscle_group")
public class MuscleGroupController {

    private final MuscleGroupService muscleGroupService;

    public MuscleGroupController(MuscleGroupService muscleGroupService) {
        this.muscleGroupService = muscleGroupService;
    }

    @PostMapping()
    public ResponseEntity<Void> save (@RequestBody MuscleGroupRequest muscleGroupRequest){
        muscleGroupService.save(muscleGroupRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idGroupMuscle}")
    public ResponseEntity<MuscleGroupResponse> getById (@PathVariable Long idGroupMuscle){
        return ResponseEntity.ok().body(muscleGroupService.getById(idGroupMuscle));
    }

    @GetMapping("/{nameGroupMuscle}")
    public ResponseEntity<MuscleGroupResponse> getByName (@PathVariable String nameGroupMuscle){
        return ResponseEntity.ok().body(muscleGroupService.getByName(nameGroupMuscle));
    }

    @PutMapping()
    public ResponseEntity<Void> update (@RequestBody Long idGroupMuscle, MuscleGroupRequest muscleGroupRequest){
        muscleGroupService.update(idGroupMuscle, muscleGroupRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idGroupMuscle}")
    public ResponseEntity<Void> delete (@PathVariable Long idGroupMuscle){
        muscleGroupService.delete(idGroupMuscle);
        return ResponseEntity.ok().build();
    }

}
