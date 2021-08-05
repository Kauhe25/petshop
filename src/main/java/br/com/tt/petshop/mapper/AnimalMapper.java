package br.com.tt.petshop.mapper;

import br.com.tt.petshop.model.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AnimalMapper {

    @Mapping(source = "animal", target = ".")
    String fromAnimal(Animal animal);
}
