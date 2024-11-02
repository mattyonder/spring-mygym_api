package br.com.gymexercicesapi.services;

import br.com.gymexercicesapi.exceptions.muscleExceptions.MuscleAlreadyExistsException;
import br.com.gymexercicesapi.exceptions.muscleExceptions.MuscleNotFindByIdException;
import br.com.gymexercicesapi.exceptions.muscleExceptions.MuscleNotFindByNameException;
import br.com.gymexercicesapi.exceptions.muscleGroupExceptions.MuscleGroupNotFindByIdException;
import br.com.gymexercicesapi.models.MuscleGroupModel;
import br.com.gymexercicesapi.models.MuscleModel;
import br.com.gymexercicesapi.models.dto.request.MuscleRequest;
import br.com.gymexercicesapi.models.dto.response.MuscleResponse;
import br.com.gymexercicesapi.repositories.MuscleGroupRepository;
import br.com.gymexercicesapi.repositories.MuscleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MuscleService {

    private final MuscleRepository muscleRepository;
    private final MuscleGroupRepository muscleGroupRepository;

    public MuscleService(MuscleRepository muscleRepository, MuscleGroupRepository muscleGroupRepository){
        this.muscleRepository = muscleRepository;
        this.muscleGroupRepository = muscleGroupRepository;
    }

    public void save (MuscleRequest muscleRequest){
        if (muscleRepository.findByName(muscleRequest.name()).isPresent())
            throw new MuscleAlreadyExistsException("Muscle already exists in the system");
        Optional<MuscleGroupModel> muscleGroupFind = muscleGroupRepository.findById(muscleRequest.idMuscleGroup());

        if (muscleGroupFind.isPresent()){
            MuscleModel muscleModel = new MuscleModel(muscleRequest, muscleGroupFind.get());
            muscleRepository.save(muscleModel);
        }
            else throw new MuscleGroupNotFindByIdException("A muscle group with this id was not found in the system");
    }

    public MuscleResponse getByName(String name){
        Optional<MuscleModel> muscleFind = muscleRepository.findByName(name);
        if (muscleFind.isPresent()){
            MuscleModel muscleModel = muscleFind.get();
            return new MuscleResponse(muscleModel);
        }
        else throw new MuscleNotFindByNameException("A muscle with this name was not found in the system");
    }

    public MuscleResponse getById(Long id){
        Optional<MuscleModel> muscleFind = muscleRepository.findById(id);
        if (muscleFind.isPresent()){
            MuscleModel muscleModel = muscleFind.get();
            return new MuscleResponse(muscleModel);
        }
        else throw new MuscleGroupNotFindByIdException("A muscle with this id was not found in the system");
    }

    public void update(Long id, MuscleRequest muscleRequest){
        Optional<MuscleModel> muscleFind = muscleRepository.findById(id);
        if (muscleFind.isPresent()){
            MuscleModel muscleModel = muscleFind.get();
            merge(muscleModel, muscleRequest);
            muscleRepository.save(muscleModel);
        } else throw new MuscleNotFindByIdException("A muscle with this id was not found in the system");
    }

    public void delete(Long id){
        Optional<MuscleModel> muscleFind = muscleRepository.findById(id);
        if (muscleFind.isPresent())
            muscleRepository.delete(muscleFind.get());
        else throw new MuscleGroupNotFindByIdException("A muscle with this id was not found in the system");
    }

    private void merge(MuscleModel lasted, MuscleRequest muscleUpdated){
        BeanUtils.copyProperties(muscleUpdated, lasted);
    }


}
