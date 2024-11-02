package br.com.gymexercicesapi.services;

import br.com.gymexercicesapi.exceptions.muscleGroupExceptions.MuscleGroupAlreadyExistsException;
import br.com.gymexercicesapi.exceptions.muscleGroupExceptions.MuscleGroupNotFindByIdException;
import br.com.gymexercicesapi.exceptions.muscleGroupExceptions.MuscleGroupNotFindByNameException;
import br.com.gymexercicesapi.models.MuscleGroupModel;
import br.com.gymexercicesapi.models.MuscleModel;
import br.com.gymexercicesapi.models.dto.request.MuscleGroupRequest;
import br.com.gymexercicesapi.models.dto.response.MuscleGroupResponse;
import br.com.gymexercicesapi.models.dto.response.MuscleResponse;
import br.com.gymexercicesapi.repositories.MuscleGroupRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MuscleGroupService {

    private final MuscleGroupRepository muscleGroupRepository;

    public MuscleGroupService(MuscleGroupRepository muscleGroupRepository){
        this.muscleGroupRepository = muscleGroupRepository;
    }

    public void save (MuscleGroupRequest muscleGroupRequest) {
        if (muscleGroupRepository.findByName(muscleGroupRequest.name()).isPresent())
            throw new MuscleGroupAlreadyExistsException("Muscle group already exists in the system");
        MuscleGroupModel muscleGroupModel = new MuscleGroupModel(muscleGroupRequest);
        muscleGroupRepository.save(muscleGroupModel);
    }

    public MuscleGroupResponse getById(Long id){
        Optional<MuscleGroupModel> muscleGroupFind = muscleGroupRepository.findById(id);
        if (muscleGroupFind.isPresent()){
            MuscleGroupModel muscleGroupModel = muscleGroupFind.get();
            List<MuscleModel> muscleModelList = muscleGroupModel.getParticipatingMuscles();
            List<MuscleResponse> muscleResponseList = muscleModelList.stream().map(MuscleResponse::new).toList();
            return new MuscleGroupResponse(muscleGroupModel, muscleResponseList);
        }
        else throw new MuscleGroupNotFindByIdException("A muscle group with this id was not found in the system");
    }

    public MuscleGroupResponse getByName(String name){
        Optional<MuscleGroupModel> muscleGroupFind = muscleGroupRepository.findByName(name);
        if (muscleGroupFind.isPresent()){
            MuscleGroupModel muscleGroupModel = muscleGroupFind.get();
            List<MuscleModel> muscleModelList = muscleGroupModel.getParticipatingMuscles();
            List<MuscleResponse> muscleResponseList = muscleModelList.stream().map(MuscleResponse::new).toList();
            return new MuscleGroupResponse(muscleGroupModel, muscleResponseList);
        }
        else throw new MuscleGroupNotFindByNameException("A muscle group with this name was not found in the system");
    }

    public void update(Long id, MuscleGroupRequest muscleGroupRequest){
        Optional<MuscleGroupModel> muscleGroupFind = muscleGroupRepository.findById(id);
        if (muscleGroupFind.isPresent()){
            MuscleGroupModel muscleGroupModel = muscleGroupFind.get();
            merge(muscleGroupModel, muscleGroupRequest);
            muscleGroupRepository.save(muscleGroupModel);
        } else throw new MuscleGroupNotFindByIdException("A muscle group with this id was not found in the system");
    }

    public void delete(Long id){
        Optional<MuscleGroupModel> muscleGroupFind = muscleGroupRepository.findById(id);
        if (muscleGroupFind.isPresent())
            muscleGroupRepository.delete(muscleGroupFind.get());
        else throw new MuscleGroupNotFindByIdException("A muscle group with this id was not found in the system");
    }

    private void merge(MuscleGroupModel lasted, MuscleGroupRequest muscleGroupUpdated){
        BeanUtils.copyProperties(muscleGroupUpdated, lasted);
    }
}
